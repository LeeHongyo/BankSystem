package com.bankingsystem.bankingapi.domain.user.service;

import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    // 사용자를 활성화/비활성화하는 메서드
    public UserEntity toggleUserActivation(Long userId, boolean active) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setVerificationStatus(active);
        return userRepository.save(user);
    }

    // 사용자 조회
    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 모든 사용자 조회
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
