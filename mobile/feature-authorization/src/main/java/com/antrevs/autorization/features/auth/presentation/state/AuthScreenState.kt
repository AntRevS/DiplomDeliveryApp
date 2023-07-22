package com.antrevs.autorization.features.auth.presentation.state

import com.antrevs.core.presentation.entity.ValueWithErrorState

data class AuthScreenState(
    val isAuth: Boolean = true,
    val isLoading: Boolean = false,
    val phoneNumber: ValueWithErrorState = ValueWithErrorState(""),
    val password: ValueWithErrorState = ValueWithErrorState(""),
)
