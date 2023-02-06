package com.antrevs.api.common;

public enum HttpHeaders {

    SESSION_ID("session_id");

    private String code;

    public String getCode() {
        return code;
    }

    HttpHeaders(String code) {
        this.code = code;
    }
}
