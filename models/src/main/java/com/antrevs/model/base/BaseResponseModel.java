package com.antrevs.model.base;

import com.antrevs.model.error.ErrorModel;

public abstract class BaseResponseModel extends BaseEntity {

    protected ErrorModel error;

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }
}
