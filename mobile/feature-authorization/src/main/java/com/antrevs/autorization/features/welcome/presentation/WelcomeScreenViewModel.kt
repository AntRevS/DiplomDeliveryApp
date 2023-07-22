package com.antrevs.autorization.features.welcome.presentation

import com.antrevs.autorization.common.domain.AuthRepository
import com.antrevs.core.presentation.BaseViewModel
import com.antrevs.core.presentation.navigation.NavArguments
import com.antrevs.core.presentation.navigation.NavEvent
import javax.inject.Inject

class WelcomeScreenViewModel @Inject constructor(
    private val repository: AuthRepository,
) : BaseViewModel() {

    fun onResume() {
        launch {
            repository.resetSession()
        }
    }

    fun onAuthButtonClick() = navigate(
        event = NavEvent.Authorization(
            args = NavArguments.Authorization(
                isAuthorization = true,
            )
        )
    )

    fun onRegisterButtonClick() = navigate(
        event = NavEvent.Authorization(
            args = NavArguments.Authorization(
                isAuthorization = false,
            )
        )
    )
}
