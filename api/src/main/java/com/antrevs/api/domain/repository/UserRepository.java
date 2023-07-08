package com.antrevs.api.domain.repository;

import com.antrevs.api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumber(String phoneNumber);

    User findBySessionId(String sessionId);
}
