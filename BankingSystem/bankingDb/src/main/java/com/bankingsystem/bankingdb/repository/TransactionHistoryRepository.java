package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryEntity, Long> {
  // 계좌 ID로 거래 내역 찾기
  List<TransactionHistoryEntity> findByAccount_AccountId(Long accountId);
}
