package com.bankingsystem.bankingapi.domain.user.converter;

import com.bankingsystem.bankingapi.dto.UserDto;
import com.bankingsystem.bankingdb.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto entityToDto(UserEntity userEntity) {
        UserDto userDTO = new UserDto();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        userDTO.setVerificationStatus(userEntity.getVerificationStatus());
        userDTO.setRegistrationDate(userEntity.getRegistrationDate());
        userDTO.setRole(userEntity.getRole().name());
        return userDTO;
    }

    public UserEntity dtoToEntity(UserDto userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setVerificationStatus(userDTO.getVerificationStatus());
        userEntity.setRegistrationDate(userDTO.getRegistrationDate());
        userEntity.setRole(UserEntity.UserRole.valueOf(userDTO.getRole()));
        return userEntity;
    }
}
