package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface
AccountRepository extends JpaRepository<AccountEntity, Long> {
  // 계좌 번호로 계좌 찾기
  AccountEntity findByAccountNumber(String accountNumber);
}
