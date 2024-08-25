package com.bankingsystem.bankingapi.domain.transaction.service;

import com.bankingsystem.bankingdb.entity.AccountEntity;
import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import com.bankingsystem.bankingdb.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryEntity createTransaction(Long accountId, TransactionHistoryEntity.TransactionType type, BigDecimal amount) {
        TransactionHistoryEntity transaction = new TransactionHistoryEntity();
        transaction.setAccount(new AccountEntity());
        transaction.getAccount().setId(accountId);
        transaction.setTransactionType(type);
        transaction.setAmount(amount);
        transaction.setTransactionTime(LocalDateTime.now());
        return transactionHistoryRepository.save(transaction);
    }

    public List<TransactionHistoryEntity> getTransactionsByAccountId(Long accountId) {
        return transactionHistoryRepository.findByAccount_AccountId(accountId);
    }
}
