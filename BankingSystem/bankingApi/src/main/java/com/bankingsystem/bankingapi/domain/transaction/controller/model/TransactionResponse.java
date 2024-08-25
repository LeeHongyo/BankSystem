package com.bankingsystem.bankingapi.domain.transaction.controller.model;

import org.springframework.http.HttpStatus;

public class TransactionResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;

    public TransactionResponse(HttpStatus status, String message, T data) {
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

    public static <T> TransactionResponse<T> success(T data) {
        return new TransactionResponse<>(HttpStatus.OK, "Success", data);
    }

    public static <T> TransactionResponse<T> error(String message) {
        return new TransactionResponse<>(HttpStatus.BAD_REQUEST, message, null);
    }
}
