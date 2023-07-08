package com.antrevs.api.privateservice.user;

import com.antrevs.api.common.ErrorCode;
import com.antrevs.api.common.HttpHeaders;
import com.antrevs.api.domain.entity.Address;
import com.antrevs.api.domain.entity.User;
import com.antrevs.api.domain.repository.AddressRepository;
import com.antrevs.api.domain.repository.UserRepository;
import com.antrevs.api.privateservice.user.mapper.AddressMapper;
import com.antrevs.api.publicservice.auth.mapper.UserMapper;
import com.antrevs.model.auth.AuthResponseModel;
import com.antrevs.model.error.ErrorModel;
import com.antrevs.model.user.GetAddressResponseModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/private/user")
public class UserController {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    private final UserMapper userMapper;

    @Autowired
    public UserController(
            UserRepository userRepository,
            AddressRepository addressRepository
    ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.addressMapper = new AddressMapper();
        this.userMapper = new UserMapper();
    }

    @GetMapping("/address")
    @ResponseBody
    public GetAddressResponseModel getAddressList(
            @RequestHeader(HttpHeaders.SESSION_ID) String sessionId
    ) {
        User user = userRepository.findBySessionId(sessionId);
        List<Address> addressList = addressRepository.findAllByCustomerId(user.getId());
        GetAddressResponseModel response = new GetAddressResponseModel();
        if (addressList.isEmpty()) {
            ErrorModel error = new ErrorModel();
            error.setErrorCode(ErrorCode.EMPTY_LIST);
            response.setError(error);
        } else {
            response.setAddressList(addressList.stream().map(addressMapper::map).collect(Collectors.toList()));
        }
        return response;
    }

    @PostMapping("/address/update")
    @ResponseBody
    public GetAddressResponseModel updateAddress(
            @RequestHeader(HttpHeaders.SESSION_ID) String sessionId,
            @RequestBody UpdateAddressRequestBody body
    ) {
        User user = userRepository.findBySessionId(sessionId);
        GetAddressResponseModel response = new GetAddressResponseModel();
        Address newAddress = Address
                .builder()
                .id(body.getId())
                .customer(user)
                .city(body.getCity())
                .street(body.getStreet())
                .house(body.getHouse())
                .flat(body.getFlat())
                .comment(body.getComment())
                .build();
        addressRepository.save(newAddress);
        List<Address> addressList = addressRepository.findAllByCustomerId(user.getId());
        response.setAddressList(addressList.stream().map(addressMapper::map).toList());
        return response;
    }

    @PostMapping("/update")
    @ResponseBody
    public AuthResponseModel updateUserInfo(
            @RequestHeader(HttpHeaders.SESSION_ID) String sessionId,
            @RequestBody UpdateUserInfoRequestBody body
    ) {
        User user = userRepository.findBySessionId(sessionId);
        AuthResponseModel response = new AuthResponseModel();
        user.setName(body.getName());
        user.setEmail(body.getEmail());
        userRepository.save(user);
        response.setUser(userMapper.map(user));
        response.setSessionId(user.getSessionId());
        return response;
    }

    @Data
    private static class UpdateUserInfoRequestBody {

        private String name;

        private String email;
    }

    @Data
    private static class UpdateAddressRequestBody {

        private Long id;

        private String city;

        private String street;

        private Long house;

        private Long flat;

        private String comment;
    }
}
