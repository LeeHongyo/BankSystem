package com.bankingsystem.bankingapi.domain.transaction.converter;

import com.bankingsystem.bankingapi.dto.TransactionDto;
import com.bankingsystem.bankingdb.entity.TransactionHistoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionConverter {

    public TransactionDto entityToDto(TransactionHistoryEntity entity) {
        TransactionDto dto = new TransactionDto();
        dto.setId(entity.getId());
        dto.setAccountId(entity.getAccount().getId());
        dto.setTransactionType(entity.getTransactionType().name());
        dto.setAmount(entity.getAmount());
        dto.setTransactionTime(entity.getTransactionTime());
        return dto;
    }

    public List<TransactionDto> entitiesToDtos(List<TransactionHistoryEntity> entities) {
        return entities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public TransactionHistoryEntity dtoToEntity(TransactionDto dto) {
        TransactionHistoryEntity entity = new TransactionHistoryEntity();
        entity.setId(dto.getId());
        entity.setTransactionType(TransactionHistoryEntity.TransactionType.valueOf(dto.getTransactionType()));
        entity.setAmount(dto.getAmount());
        entity.setTransactionTime(dto.getTransactionTime());
        // AccountEntity 설정 필요
        return entity;
    }
}
