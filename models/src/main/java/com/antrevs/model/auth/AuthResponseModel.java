package com.antrevs.model.auth;

import com.antrevs.model.base.BaseResponseModel;
import com.antrevs.model.entity.UserModel;

public class AuthResponseModel extends BaseResponseModel {

    private UserModel user;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
