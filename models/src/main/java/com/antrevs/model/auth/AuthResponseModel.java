package com.antrevs.model.auth;

import com.antrevs.model.base.BaseResponseModel;
import com.antrevs.model.entity.UserModel;

public class AuthResponseModel extends BaseResponseModel {

    private UserModel user;

    private String sessionId;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
