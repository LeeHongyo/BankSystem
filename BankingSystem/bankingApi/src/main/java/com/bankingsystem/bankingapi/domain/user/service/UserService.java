package com.bankingsystem.bankingapi.domain.user.service;

import com.bankingsystem.bankingapi.domain.user.service.IdentityVerificationService;
import com.bankingsystem.bankingapi.dto.UserDto;
import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IdentityVerificationService identityVerificationService;

    public UserEntity registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setVerificationStatus(false);
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public UserEntity authenticate(String username, String password) {
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt.get();
        }
        return null;
    }

    // 사용자 이름으로 사용자 찾기
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 전화번호로 사용자 찾기
    public UserEntity findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 신분증 검증을 포함한 사용자 등록
    public UserEntity registerUser(UserDto userDto, String idCardNumber) {
        if (!identityVerificationService.verifyIdentity(userDto.getUserId().toString(), idCardNumber)) {
            throw new RuntimeException("Identity verification failed");
        }

        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setVerificationStatus(true); // 인증된 상태로 설정
        user.setRegistrationDate(LocalDateTime.now());
        user.setRole(UserEntity.UserRole.USER);

        return userRepository.save(user);
    }

    // 사용자 프로필 업데이트
    public UserEntity updateUserProfile(Long userId, UserDto userDto) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDto.getUsername());
        user.setPhoneNumber(userDto.getPhoneNumber());

        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        return userRepository.save(user);
    }

}
