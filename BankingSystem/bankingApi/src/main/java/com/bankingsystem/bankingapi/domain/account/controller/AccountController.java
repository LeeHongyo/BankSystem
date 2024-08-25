package com.bankingsystem.bankingapi.domain.account.controller;

import com.bankingsystem.bankingapi.dto.AccountDto;
import com.bankingsystem.bankingapi.domain.account.service.AccountService;
import com.bankingsystem.bankingapi.domain.account.converter.AccountConverter;
import com.bankingsystem.bankingdb.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter accountConverter;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestParam Long userId) {
        AccountEntity account = accountService.createAccount(userId);
        return ResponseEntity.ok(accountConverter.entityToDto(account));
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BigDecimal> checkBalance(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.checkBalance(accountId));
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        accountService.deposit(accountId, amount);
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        accountService.withdraw(accountId, amount);
        return ResponseEntity.ok("Withdrawal successful");
    }
}
