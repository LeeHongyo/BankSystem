package com.bankingsystem.bankingapi.domain.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityVerificationService {

    private final ExternalIdentityVerificationClient externalClient;

    @Autowired
    public IdentityVerificationService(ExternalIdentityVerificationClient externalClient) {
        this.externalClient = externalClient;
    }

    public boolean verifyIdentity(String userId, String idCardNumber) {
        VerificationRequest request = new VerificationRequest();
        request.setUserId(userId);
        request.setIdCardNumber(idCardNumber);

        VerificationResponse response = externalClient.verifyIdentity(request);

        return response.isValid() && idCardNumber.equals(response.getIdCardNumber());
    }
}
