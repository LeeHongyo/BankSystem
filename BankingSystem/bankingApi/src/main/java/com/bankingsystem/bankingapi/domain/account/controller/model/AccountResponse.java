package com.bankingsystem.bankingapi.domain.account.controller.model;

import org.springframework.http.HttpStatus;

public class AccountResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;

    public AccountResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> AccountResponse<T> success(T data) {
        return new AccountResponse<>(HttpStatus.OK, "Success", data);
    }

    public static <T> AccountResponse<T> error(String message) {
        return new AccountResponse<>(HttpStatus.BAD_REQUEST, message, null);
    }
}