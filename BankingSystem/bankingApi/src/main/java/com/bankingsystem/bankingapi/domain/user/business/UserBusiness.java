package com.bankingsystem.bankingapi.domain.user.business;

import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserBusiness {

    @Autowired
    private UserRepository userRepository;

    // 사용자 등록 비즈니스 로직
    public UserEntity registerUser(UserEntity user) {
        user.setVerificationStatus(false);
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    // 사용자 이름으로 찾기 비즈니스 로직
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
