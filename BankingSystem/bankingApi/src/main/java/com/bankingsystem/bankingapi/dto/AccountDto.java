package com.bankingsystem.bankingapi.dto;

import java.math.BigDecimal;

public class AccountDto {
    private Long accountId;
    private String accountNumber;
    private BigDecimal balance;
    private Long userId;

    // Getter and Setter for accountId
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    // Getter and Setter for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter and Setter for balance
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // Getter and Setter for userId
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Optional: toString method
    @Override
    public String toString() {
        return "AccountDto{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", userId=" + userId +
                '}';
    }

    // Optional: equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDto that = (AccountDto) o;

        if (!accountId.equals(that.accountId)) return false;
        if (!accountNumber.equals(that.accountNumber)) return false;
        if (!balance.equals(that.balance)) return false;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        int result = accountId.hashCode();
        result = 31 * result + accountNumber.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }
}
