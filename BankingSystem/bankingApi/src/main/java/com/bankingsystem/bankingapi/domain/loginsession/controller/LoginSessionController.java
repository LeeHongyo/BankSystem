package com.bankingsystem.bankingapi.domain.loginsession.controller;

import com.bankingsystem.bankingapi.domain.loginsession.service.LoginSessionService;
import com.bankingsystem.bankingdb.entity.LoginSessionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class LoginSessionController {

    @Autowired
    private LoginSessionService loginSessionService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<LoginSessionEntity> createSession(@PathVariable Long userId) {
        LoginSessionEntity session = loginSessionService.createSession(userId);
        return ResponseEntity.ok(session);
    }

    @PutMapping("/end/{sessionId}")
    public ResponseEntity<Void> endSession(@PathVariable Long sessionId) {
        loginSessionService.endSession(sessionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoginSessionEntity>> getSessionsByUserId(@PathVariable Long userId) {
        List<LoginSessionEntity> sessions = loginSessionService.getSessionsByUserId(userId);
        return ResponseEntity.ok(sessions);
    }
}
