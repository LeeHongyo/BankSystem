package com.bankingsystem.bankingapi.domain.loginsession.converter;

import com.bankingsystem.bankingapi.dto.LoginSessionDto;
import com.bankingsystem.bankingdb.entity.LoginSessionEntity;
import org.springframework.stereotype.Component;

@Component
public class LoginSessionConverter {

    // 엔티티를 DTO로 변환
    public LoginSessionDto entityToDto(LoginSessionEntity entity) {
        if (entity == null) {
            return null;
        }
        LoginSessionDto dto = new LoginSessionDto();
        dto.setSessionId(entity.getSessionId());
        dto.setUserId(entity.getUser().getUserId());
        dto.setLoginTime(entity.getLoginTime());
        dto.setLogoutTime(entity.getLogoutTime());
        return dto;
    }

    // DTO를 엔티티로 변환
    public LoginSessionEntity dtoToEntity(LoginSessionDto dto) {
        if (dto == null) {
            return null;
        }
        LoginSessionEntity entity = new LoginSessionEntity();
        entity.setSessionId(dto.getSessionId());
        // 여기에 userId가 필요한 경우, UserEntity를 실제로 조회하거나 setter를 사용할 수 있습니다.
        // 예: UserEntity user = userRepository.findById(dto.getUserId()).orElse(null);
        // entity.setUser(user);
        entity.setLoginTime(dto.getLoginTime());
        entity.setLogoutTime(dto.getLogoutTime());
        return entity;
    }
}
