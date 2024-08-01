package com.bankingsystem.bankingdb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginSessionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sessionId;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private UserEntity user;

  @Column(nullable = false)
  private LocalDateTime loginTime;

  @Column
  private LocalDateTime logoutTime;

  // Getters and Setters
  public Long getSessionId() {
    return sessionId;
  }

  public void setSessionId(Long sessionId) {
    this.sessionId = sessionId;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public LocalDateTime getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(LocalDateTime loginTime) {
    this.loginTime = loginTime;
  }

  public LocalDateTime getLogoutTime() {
    return logoutTime;
  }

  public void setLogoutTime(LocalDateTime logoutTime) {
    this.logoutTime = logoutTime;
  }
}