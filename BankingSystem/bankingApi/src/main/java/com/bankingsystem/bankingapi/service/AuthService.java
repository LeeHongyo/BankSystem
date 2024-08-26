package com.bankingsystem.bankingapi.service;

import com.bankingsystem.bankingapi.util.JwtUtil;
import com.bankingsystem.bankingapi.domain.user.service.UserService;
import com.bankingsystem.bankingdb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String username, String password) {
        UserEntity user = userService.authenticate(username, password);
        if (user != null) {
            return jwtUtil.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }

}
