package com.bankingsystem.bankingdb.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Collection;

@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(nullable = false, length = 15, unique = true)
  private String phoneNumber;

  @Column(nullable = false)
  private Boolean verificationStatus = false;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserRole role; // enum으로 역할 정의

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public Collection<? extends GrantedAuthority> getRoles() {
    return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
  }

  public enum UserRole {
    USER,
    SUBSCRIBER
  }
}
