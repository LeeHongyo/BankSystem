package com.bankingsystem.bankingapi.domain.user.service;

import org.springframework.stereotype.Component;

@Component
public class ExternalIdentityVerificationClient {

    public VerificationResponse verifyIdentity(VerificationRequest request) {
        // 외부 API 통신 로직을 여기에 작성합니다.
        // 이 예에서는 더미 응답을 반환합니다.

        VerificationResponse response = new VerificationResponse();
        response.setValid(true);
        response.setIdCardNumber(request.getIdCardNumber());

        return response;
    }
}
