package com.bankingsystem.bankingapi.domain.user.business;

import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserBusiness {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 사용자 등록
    public UserEntity registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setVerificationStatus(false);
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    // 사용자 인증
    public UserEntity authenticate(String username, String password) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
            return userOptional.get();
        }
        return null;
    }

    // 사용자 이름으로 사용자 찾기
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 전화번호로 사용자 찾기 (추가적인 메서드 예시)
    public UserEntity findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
