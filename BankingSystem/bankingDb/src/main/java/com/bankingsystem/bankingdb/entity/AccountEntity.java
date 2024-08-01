package com.bankingsystem.bankingdb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accountId;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private UserEntity user;

  @Column(nullable = false, unique = true, length = 20)
  private String accountNumber;

  @Column(nullable = false)
  private Double balance;

  @Column(nullable = false)
  private LocalDateTime creationDate;

  // Getters and Setters
  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }
}
