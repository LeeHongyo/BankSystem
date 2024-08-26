package com.bankingsystem.bankingapi.domain.transaction.business;

import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import com.bankingsystem.bankingapi.domain.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TransactionBusiness {

    @Autowired
    private TransactionService transactionService;

    // 거래 생성 비즈니스 로직
    public TransactionHistoryEntity createTransaction(Long accountId, TransactionHistoryEntity.TransactionType type, BigDecimal amount) {
        return transactionService.createTransaction(accountId, type, amount);
    }

    // 계좌 ID로 거래 내역 조회
    public List<TransactionHistoryEntity> getTransactionsByAccountId(Long accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
