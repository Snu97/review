package com.review.coffeeShop.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXIST(404, "Member not found"),
    SERVER_ERROR(500, "Server error");

    private int code;
    private String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
