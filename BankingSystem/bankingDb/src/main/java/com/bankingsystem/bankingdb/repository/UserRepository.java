package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
 // 사용자 이름으로 사용자 찾기
 Optional<UserEntity> findByUsername(String username);

 // 전화번호로 사용자 찾기
 Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
