package com.antrevs.api.publicservice.auth.mapper;

import com.antrevs.api.domain.entity.User;
import com.antrevs.api.mapper.BaseMapper;
import com.antrevs.model.entity.UserModel;

public class UserMapper implements BaseMapper<User, UserModel> {

    @Override
    public UserModel map(User user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setRole(user.getRole());
        model.setName(user.getName());
        model.setPhoneNumber(user.getPhoneNumber());
        model.setEmail(user.getEmail());
        return model;
    }
}
