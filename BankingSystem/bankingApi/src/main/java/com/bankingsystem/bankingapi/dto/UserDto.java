package com.bankingsystem.bankingapi.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import com.bankingsystem.bankingdb.entity.UserEntity;

public class UserDto {

    @NotNull
    private Long userId;

    @NotNull
    private String password;

    @NotEmpty
    private String username;

    @NotEmpty
    private String phoneNumber;

    @NotNull
    private Boolean verificationStatus;

    @NotNull
    private LocalDateTime registrationDate;

    @NotEmpty
    private String role;

    public UserDto(UserEntity userEntity) {
        this.userId = userEntity.getUserId();
        this.password = userEntity.getPassword(); // 필요에 따라 암호화된 패스워드를 전달
        this.username = userEntity.getUsername();
        this.phoneNumber = userEntity.getPhoneNumber();
        this.verificationStatus = userEntity.getVerificationStatus();
        this.registrationDate = userEntity.getRegistrationDate();
        this.role = userEntity.getRole().name(); // Enum을 String으로 변환
    }

    // 기본 생성자도 추가할 수 있음 (필요시)
    public UserDto() {}

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
