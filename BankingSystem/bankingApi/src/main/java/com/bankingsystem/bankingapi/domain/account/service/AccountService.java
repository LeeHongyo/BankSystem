package com.bankingsystem.bankingapi.domain.account.service;

import com.bankingsystem.bankingdb.entity.AccountEntity;
import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountEntity createAccount(String accountNumber, Long userId) {
        AccountEntity account = new AccountEntity();
        account.setAccountNumber(accountNumber);
        account.setBalance(BigDecimal.ZERO);
        account.setCreationDate(LocalDateTime.now());
        account.setUser(new UserEntity()); // UserEntity를 실제로 조회하여 설정
        account.getUser().setUserId(userId);
        return accountRepository.save(account);
    }

    public AccountEntity updateAccount(Long accountId, BigDecimal newBalance) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    public AccountEntity findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
