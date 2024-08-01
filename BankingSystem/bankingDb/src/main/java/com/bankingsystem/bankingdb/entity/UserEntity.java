package com.bankingsystem.bankingdb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(nullable = false, length = 50)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true, length = 15)
  private String phoneNumber;

  @Column(nullable = false)
  private Boolean verificationStatus;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

  // Getters and Setters
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
}
