package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.LoginSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginSessionRepository extends JpaRepository<LoginSessionEntity, Long> {

}
