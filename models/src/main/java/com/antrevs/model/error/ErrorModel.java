package com.antrevs.model.error;

import com.antrevs.model.base.BaseEntity;

public class ErrorModel extends BaseEntity {

    private String errorMsg;

    private String errorCode;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
