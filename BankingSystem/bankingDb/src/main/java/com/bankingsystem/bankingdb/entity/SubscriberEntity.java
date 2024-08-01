package com.bankingsystem.bankingdb.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SubscriberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long subscriberId;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, unique = true, length = 100)
  private String email;

  @Column(nullable = false)
  private LocalDateTime subscriptionStartDate;

  @Column(nullable = false)
  private Boolean subscriptionStatus;

  // Getters and Setters
  public Long getSubscriberId() {
    return subscriberId;
  }

  public void setSubscriberId(Long subscriberId) {
    this.subscriberId = subscriberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getSubscriptionStartDate() {
    return subscriptionStartDate;
  }

  public void setSubscriptionStartDate(LocalDateTime subscriptionStartDate) {
    this.subscriptionStartDate = subscriptionStartDate;
  }

  public Boolean getSubscriptionStatus() {
    return subscriptionStatus;
  }

  public void setSubscriptionStatus(Boolean subscriptionStatus) {
    this.subscriptionStatus = subscriptionStatus;
  }
}
