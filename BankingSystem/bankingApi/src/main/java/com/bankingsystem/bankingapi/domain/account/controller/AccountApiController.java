package com.bankingsystem.bankingapi.domain.account.controller;

import com.bankingsystem.bankingapi.dto.AccountDto;
import com.bankingsystem.bankingapi.domain.account.service.AccountService;
import com.bankingsystem.bankingdb.entity.AccountEntity;
import com.bankingsystem.bankingapi.domain.account.converter.AccountConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountApiController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter accountConverter;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestParam String accountNumber, @RequestParam Long userId) {
        AccountEntity account = accountService.createAccount(accountNumber, userId);
        return ResponseEntity.ok(accountConverter.entityToDto(account));
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long accountId, @RequestParam BigDecimal newBalance) {
        AccountEntity account = accountService.updateAccount(accountId, newBalance);
        return ResponseEntity.ok(accountConverter.entityToDto(account));
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> getAccountByAccountNumber(@PathVariable String accountNumber) {
        AccountEntity account = accountService.findByAccountNumber(accountNumber);
        return ResponseEntity.ok(accountConverter.entityToDto(account));
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        accountService.deposit(accountId, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Void> withdraw(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        try {
            accountService.withdraw(accountId, amount);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
