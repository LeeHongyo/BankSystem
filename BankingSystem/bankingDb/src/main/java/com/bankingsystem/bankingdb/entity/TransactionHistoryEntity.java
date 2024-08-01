package com.bankingsystem.bankingdb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TransactionHistoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transactionId;

  @ManyToOne
  @JoinColumn(name = "accountId", nullable = false)
  private AccountEntity account;

  @Column(nullable = false)
  private Double amount;

  @Column(nullable = false, length = 10)
  private String transactionType; // "DEPOSIT" or "WITHDRAWAL"

  @Column(nullable = false)
  private LocalDateTime transactionDate;

  // Getters and Setters
  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  public LocalDateTime getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDateTime transactionDate) {
    this.transactionDate = transactionDate;
  }
}
