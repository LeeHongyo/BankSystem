package com.bankingsystem.bankingapi.domain.account.service;

import com.bankingsystem.bankingdb.entity.AccountEntity;
import com.bankingsystem.bankingdb.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        AccountEntity fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From Account not found"));
        AccountEntity toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("To Account not found"));

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
