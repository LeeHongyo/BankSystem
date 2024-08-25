package com.bankingsystem.bankingapi.domain.user.controller;

import com.bankingsystem.bankingapi.domain.user.converter.UserConverter;
import com.bankingsystem.bankingapi.dto.UserDto;
import com.bankingsystem.bankingapi.domain.user.service.UserService;
import com.bankingsystem.bankingdb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDTO) {
        UserEntity userEntity = userConverter.dtoToEntity(userDTO);
        UserEntity registeredUser = userService.registerUser(userEntity);
        return ResponseEntity.ok(userConverter.entityToDto(registeredUser));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        UserEntity userEntity = userService.findUserByUsername(username);
        return ResponseEntity.ok(userConverter.entityToDto(userEntity));
    }
}
