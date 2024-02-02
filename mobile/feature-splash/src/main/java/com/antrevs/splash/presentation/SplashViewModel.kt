package com.antrevs.splash.presentation

import com.antrevs.core.presentation.BaseViewModel
import com.antrevs.core.presentation.navigation.MainInitialScreenType
import com.antrevs.core.presentation.navigation.NavArguments
import com.antrevs.core.presentation.navigation.NavEvent
import com.antrevs.splash.domain.SessionRepository
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val sessionRepository: SessionRepository,
) : BaseViewModel() {

    fun onResume() = launch {
        if (sessionRepository.isSessionExist()) {
            navigate(NavEvent.Main)
        } else {
            navigate(NavEvent.Welcome)
        }
    }
}
