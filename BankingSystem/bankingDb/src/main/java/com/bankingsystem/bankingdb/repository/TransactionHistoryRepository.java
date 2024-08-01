package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryEntity, Long> {

}
