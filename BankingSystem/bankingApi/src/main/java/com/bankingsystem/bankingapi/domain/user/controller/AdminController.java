package com.bankingsystem.bankingapi.domain.user.controller;

import com.bankingsystem.bankingapi.domain.user.service.AdminService;
import com.bankingsystem.bankingapi.dto.UserDto;
import com.bankingsystem.bankingdb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/users")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PutMapping("/{userId}/activation")
    public ResponseEntity<UserDto> toggleUserActivation(
            @PathVariable Long userId,
            @RequestParam boolean active) {
        UserEntity updatedUser = adminService.toggleUserActivation(userId, active);
        return ResponseEntity.ok(new UserDto(updatedUser));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        UserEntity user = adminService.getUserById(userId);
        return ResponseEntity.ok(new UserDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserEntity> users = adminService.getAllUsers();
        List<UserDto> userDtos = users.stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDtos);
    }
}
