package com.bankingsystem.bankingapi.domain.transaction.controller;

import com.bankingsystem.bankingapi.dto.TransactionDto;
import com.bankingsystem.bankingapi.domain.transaction.business.TransactionBusiness;
import com.bankingsystem.bankingapi.domain.transaction.converter.TransactionConverter;
import com.bankingsystem.bankingapi.domain.transaction.controller.model.TransactionResponse;
import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionApiController {

    @Autowired
    private TransactionBusiness transactionBusiness;

    @Autowired
    private TransactionConverter transactionConverter;

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse<TransactionDto>> createTransaction(@RequestParam Long accountId, @RequestParam TransactionHistoryEntity.TransactionType type, @RequestParam BigDecimal amount) {
        try {
            TransactionHistoryEntity transaction = transactionBusiness.createTransaction(accountId, type, amount);
            TransactionDto transactionDto = transactionConverter.entityToDto(transaction);
            return ResponseEntity.ok(TransactionResponse.success(transactionDto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(TransactionResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<TransactionResponse<List<TransactionDto>>> getTransactionsByAccountId(@PathVariable Long accountId) {
        try {
            List<TransactionHistoryEntity> transactions = transactionBusiness.getTransactionsByAccountId(accountId);
            List<TransactionDto> transactionDtos = transactionConverter.entitiesToDtos(transactions);
            return ResponseEntity.ok(TransactionResponse.success(transactionDtos));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(TransactionResponse.error(e.getMessage()));
        }
    }
}
