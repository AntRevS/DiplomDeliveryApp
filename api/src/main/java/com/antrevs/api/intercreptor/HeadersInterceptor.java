package com.antrevs.api.intercreptor;

import com.antrevs.api.common.HttpHeaders;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class HeadersInterceptor implements HandlerInterceptor {

    private final SessionRepository<Session> sessionRepository;

    @Autowired
    public HeadersInterceptor(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {
        String sessionId = request.getHeader(HttpHeaders.SESSION_ID);
        if (sessionId == null || sessionRepository.findById(sessionId) == null) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
