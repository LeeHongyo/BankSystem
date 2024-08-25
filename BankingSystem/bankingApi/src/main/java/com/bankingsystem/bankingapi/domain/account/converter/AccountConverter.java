package com.bankingsystem.bankingapi.domain.account.converter;

import com.bankingsystem.bankingapi.dto.AccountDto;
import com.bankingsystem.bankingdb.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {

    public AccountDto entityToDto(AccountEntity accountEntity) {
        AccountDto dto = new AccountDto();
        dto.setAccountId(accountEntity.getId());
        dto.setAccountNumber(accountEntity.getAccountNumber());
        dto.setBalance(accountEntity.getBalance());
        dto.setUserId(accountEntity.getUser().getUserId());
        return dto;
    }

    public AccountEntity dtoToEntity(AccountDto accountDto) {
        AccountEntity entity = new AccountEntity();
        entity.setId(accountDto.getAccountId());
        entity.setAccountNumber(accountDto.getAccountNumber());
        entity.setBalance(accountDto.getBalance());
        return entity;
    }
}
