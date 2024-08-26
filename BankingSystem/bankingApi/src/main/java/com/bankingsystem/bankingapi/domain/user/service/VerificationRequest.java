package com.bankingsystem.bankingapi.domain.user.service;

import org.springframework.web.multipart.MultipartFile;

public class VerificationRequest {
    private String userId;
    private String idCardNumber;
    private MultipartFile idCardImage;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public MultipartFile getIdCardImage() {
        return idCardImage;
    }

    public void setIdCardImage(MultipartFile idCardImage) {
        this.idCardImage = idCardImage;
    }
}
