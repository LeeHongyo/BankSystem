package com.bankingsystem.bankingdb.repository;

import com.bankingsystem.bankingdb.entity.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {

}
