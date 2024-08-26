package com.bankingsystem.bankingapi.domain.user.service;

import org.springframework.stereotype.Service;

@Service
public class IdentityVerificationService {

    // 신분증 인증 API와 통합된 외부 클라이언트
    private final ExternalIdentityVerificationClient externalClient;

    public IdentityVerificationService(ExternalIdentityVerificationClient externalClient) {
        this.externalClient = externalClient;
    }

    public boolean verifyIdentity(String userId, String idCardNumber) {
        // 신분증 검증 요청을 외부 시스템에 전달
        VerificationRequest request = new VerificationRequest();
        request.setUserId(userId);
        request.setIdCardNumber(idCardNumber);

        VerificationResponse response = externalClient.verifyIdentity(request);

        // 검증 결과를 반환
        return response.isValid() && idCardNumber.equals(response.getIdCardNumber());
    }
}
