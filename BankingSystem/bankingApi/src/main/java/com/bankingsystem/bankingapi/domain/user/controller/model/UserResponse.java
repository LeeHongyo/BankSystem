package com.bankingsystem.bankingapi.domain.user.controller.model;

import org.springframework.http.HttpStatus;

public class UserResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;

    public UserResponse(HttpStatus status, String message, T data) {
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

    public static <T> UserResponse<T> success(T data) {
        return new UserResponse<>(HttpStatus.OK, "Success", data);
    }

    public static <T> UserResponse<T> error(String message) {
        return new UserResponse<>(HttpStatus.BAD_REQUEST, message, null);
    }
}
