package com.bankingsystem.bankingapi.domain.account.business;

import com.bankingsystem.bankingdb.entity.AccountEntity;
import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import com.bankingsystem.bankingdb.entity.UserEntity;
import com.bankingsystem.bankingdb.repository.AccountRepository;
import com.bankingsystem.bankingdb.repository.TransactionHistoryRepository;
import com.bankingsystem.bankingdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class AccountBusiness {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    // 계좌 생성
    public AccountEntity createAccount(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        AccountEntity account = new AccountEntity();
        account.setAccountNumber(generateUniqueAccountNumber());
        account.setBalance(BigDecimal.ZERO); // 초기 잔액 0
        account.setCreationDate(LocalDateTime.now());
        account.setUser(user);

        return accountRepository.save(account);
    }

    // 잔액 확인
    public BigDecimal checkBalance(Long accountId) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }

    // 입금
    public void deposit(Long accountId, BigDecimal amount) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance().add(amount));

        TransactionHistoryEntity history = new TransactionHistoryEntity();
        history.setAccount(account);
        history.setTransactionType(TransactionHistoryEntity.TransactionType.Deposit);
        history.setAmount(amount);
        history.setTransactionTime(LocalDateTime.now());

        transactionHistoryRepository.save(history);
        accountRepository.save(account);
    }

    // 출금
    public void withdraw(Long accountId, BigDecimal amount) {
        AccountEntity account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));

        TransactionHistoryEntity history = new TransactionHistoryEntity();
        history.setAccount(account);
        history.setTransactionType(TransactionHistoryEntity.TransactionType.Withdrawal);
        history.setAmount(amount);
        history.setTransactionTime(LocalDateTime.now());

        transactionHistoryRepository.save(history);
        accountRepository.save(account);
    }

    // 고유 계좌번호 생성
    private String generateUniqueAccountNumber() {
        // 고유한 계좌번호 생성 로직 (예시)
        return "1234567890123";
    }
}
