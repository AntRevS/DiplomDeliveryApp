package com.antrevs.api.publicservice.auth;

import com.antrevs.api.domain.entity.User;
import com.antrevs.api.common.ErrorCode;
import com.antrevs.api.common.UserRole;
import com.antrevs.api.publicservice.auth.mapper.UserMapper;
import com.antrevs.api.domain.repository.UserRepository;
import com.antrevs.model.auth.AuthResponseModel;
import com.antrevs.model.auth.RegisterResponseModel;
import com.antrevs.model.error.ErrorModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/public")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final UserMapper userMapper;

    private final SessionRepository<Session> sessionRepository;

    @Autowired
    public AuthController(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
        this.userMapper = new UserMapper();
        this.sessionRepository = sessionRepository;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public RegisterResponseModel register(@RequestBody AuthRequestBody body) {
        final RegisterResponseModel response = new RegisterResponseModel();

        if (userRepository.findByPhoneNumber(body.getPhoneNumber()) != null) {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.USER_EXIST);
            response.setError(error);
            return response;
        }
        User user = User
                .builder()
                .role(UserRole.CUSTOMER.getCode())
                .phoneNumber(body.getPhoneNumber())
                .password(encoder.encode(body.getPassword()))
                .build();
        userRepository.save(user);

        response.setUser(userMapper.map(user));
        return response;
    }

    @PostMapping("/auth")
    @ResponseBody
    public AuthResponseModel auth(@RequestBody AuthRequestBody body) {
        final AuthResponseModel response = new AuthResponseModel();
        User user = userRepository.findByPhoneNumber(body.getPhoneNumber());

        if (user == null || !encoder.matches(body.getPassword(), user.getPassword())) {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.INCORRECT_PASSWORD);
            response.setError(error);
            return response;
        }
        String currentSessionId = user.getSessionId();
        if (currentSessionId != null) {
            sessionRepository.deleteById(currentSessionId);
        }
        Session newSession = sessionRepository.createSession();
        sessionRepository.save(newSession);
        user.setSessionId(newSession.getId());
        userRepository.save(user);
        response.setUser(userMapper.map(user));
        response.setSessionId(newSession.getId());
        return response;
    }

    @Data
    private static class AuthRequestBody {

        private String phoneNumber;

        private String password;
    }
}
