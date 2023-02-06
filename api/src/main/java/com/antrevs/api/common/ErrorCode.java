package com.antrevs.api.common;

public enum ErrorCode {

    USER_EXIST("user_exist"),
    INCORRECT_PASSWORD("incorrect_password");

    private String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
