package com.antrevs.api.common;

public enum UserRole {

    CUSTOMER("customer"),
    CONTRACTOR("contractor");

    private String code;

    UserRole(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
