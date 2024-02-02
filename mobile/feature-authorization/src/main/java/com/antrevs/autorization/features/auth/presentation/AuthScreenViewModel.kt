package com.antrevs.autorization.features.auth.presentation

import com.antrevs.authorization.R
import com.antrevs.autorization.common.domain.AuthRepository
import com.antrevs.autorization.features.auth.presentation.state.AuthScreenState
import com.antrevs.core.presentation.BaseViewModel
import com.antrevs.core.presentation.event.AlertEvent
import com.antrevs.core.presentation.navigation.MainInitialScreenType
import com.antrevs.core.presentation.navigation.NavArguments
import com.antrevs.core.presentation.navigation.NavEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class AuthScreenViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val isAuth: Boolean,
) : BaseViewModel() {

    private val _state = MutableStateFlow(AuthScreenState())
    val state = _state.asStateFlow()

    fun onCreate() {
        _state.update { it.copy(isAuth = isAuth) }
    }

    fun onPhoneNumberValueChange(value: String) {
        _state.update { state ->
            state.copy(
                phoneNumber = state.phoneNumber.copy(
                    value = value,
                    isError = false,
                )
            )
        }
    }

    fun onPasswordValueChange(value: String) {
        _state.update { state ->
            state.copy(
                password = state.password.copy(
                    value = value,
                    isError = false,
                )
            )
        }
    }

    fun onBottomButtonClick() {
        runIfValid {
            launch {
                _state.update { it.copy(isLoading = true) }
                _state.value.run {
                    if (isAuth) {
                        processAuth(
                            phoneNumber = phoneNumber.value,
                            password = password.value,
                        )
                    } else {
                        processRegistration(
                            phoneNumber = phoneNumber.value,
                            password = password.value,
                        )
                    }
                }
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    private suspend fun processRegistration(
        phoneNumber: String,
        password: String,
    ) {
        repository.register(
            phoneNumber = phoneNumber,
            password = password,
        )
        showAlert(
            AlertEvent(
                textRes = R.string.register_success,
                action = {
                    navigate(
                        NavEvent.Authorization(
                            args = NavArguments.Authorization(
                                isAuthorization = true,
                            ),
                        )
                    )
                }
            )
        )
    }

    private suspend fun processAuth(
        phoneNumber: String,
        password: String,
    ) {
        repository.auth(
            phoneNumber = phoneNumber,
            password = password,
        )
        navigate(NavEvent.Main)
    }

    fun onBackClick() = navigate(NavEvent.Back)

    private fun runIfValid(
        action: () -> Unit,
    ) {
        var isValid = true
        _state.value.run {
            if (phoneNumber.value.length < 12) {
                _state.update { state ->
                    state.copy(
                        phoneNumber = state.phoneNumber.copy(isError = true),
                    )
                }
                isValid = false
            }
            if (password.value.length < 8) {
                _state.update { state ->
                    state.copy(
                        password = state.password.copy(isError = true),
                    )
                }
                isValid = false
            }
        }
        if (isValid) {
            action()
        }
    }
}
