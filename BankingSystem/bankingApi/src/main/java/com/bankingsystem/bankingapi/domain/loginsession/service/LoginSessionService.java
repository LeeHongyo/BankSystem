package com.bankingsystem.bankingapi.domain.loginsession.service;

import com.bankingsystem.bankingdb.entity.LoginSessionEntity;
import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.LoginSessionRepository;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginSessionService {

    @Autowired
    private LoginSessionRepository loginSessionRepository;

    @Autowired
    private UserRepository userRepository;

    // 로그인 세션 생성
    public LoginSessionEntity createSession(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LoginSessionEntity session = new LoginSessionEntity();
        session.setUser(user);
        session.setLoginTime(LocalDateTime.now());
        return loginSessionRepository.save(session);
    }

    // 로그인 세션 종료
    public void endSession(Long sessionId) {
        LoginSessionEntity session = loginSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setLogoutTime(LocalDateTime.now());
        loginSessionRepository.save(session);
    }

    // 사용자 ID로 로그인 세션 조회
    public List<LoginSessionEntity> getSessionsByUserId(Long userId) {
        return loginSessionRepository.findByUser_UserId(userId);
    }
}
