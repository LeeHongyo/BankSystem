package com.bankingsystem.bankingapi.domain.account.business;

import com.bankingsystem.bankingdb.entity.AccountEntity;
import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.AccountRepository;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AccountBusiness {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    // 계좌 생성 비즈니스 로직
    public AccountEntity createAccount(Long userId) {
        AccountEntity account = new AccountEntity();
        account.setAccountNumber(generateUniqueAccountNumber());
        account.setBalance(BigDecimal.ZERO);
        account.setCreationDate(LocalDateTime.now());

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        account.setUser(user);

        return accountRepository.save(account);
    }

    // 잔액 확인 비즈니스 로직
    public BigDecimal checkBalance(Long accountId) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    // 입금 비즈니스 로직
    public void deposit(Long accountId, BigDecimal amount) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance().add(amount));

        // 이곳에서 TransactionHistory를 기록하는 로직 추가 가능

        accountRepository.save(account);
    }

    // 출금 비즈니스 로직
    public void withdraw(Long accountId, BigDecimal amount) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));

        // 이곳에서 TransactionHistory를 기록하는 로직 추가 가능

        accountRepository.save(account);
    }

    // 고유 계좌번호 생성
    private String generateUniqueAccountNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 13); // 13자리 계좌번호
    }
}
