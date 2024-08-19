package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.LoginSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoginSessionRepository extends JpaRepository<LoginSessionEntity, Long> {
  // 사용자 ID로 로그인 세션 찾기
  List<LoginSessionEntity> findByUser_UserId(Long userId);
}
