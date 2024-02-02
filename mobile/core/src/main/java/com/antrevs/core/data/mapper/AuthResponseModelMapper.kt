package com.antrevs.core.data.mapper

import com.antrevs.core.domain.entity.User
import com.antrevs.model.auth.AuthResponseModel

fun AuthResponseModel.toUser() = with(user) {
    User(
        name = name,
        phoneNumber = phoneNumber,
        email = email,
    )
}
