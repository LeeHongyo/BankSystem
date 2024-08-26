package com.bankingsystem.bankingapi.domain.user.service;

import org.springframework.stereotype.Component;

@Component
public class ExternalIdentityVerificationClient {

    public VerificationResponse verifyIdentity(VerificationRequest request) {
        // 더미 응답을 반환
        VerificationResponse response = new VerificationResponse();
        response.setValid(true);
        response.setIdCardNumber(request.getIdCardNumber());

        return response;
    }
}
