package com.antrevs.core.presentation.navigation

import java.io.Serializable

sealed class NavEvent(
    val route: String? = null,
    val clearBackStack: Boolean = false,
    open val args: NavArguments? = null,
) {

    data class Authorization(
        override val args: NavArguments.Authorization,
    ) : NavEvent(
        route = NavRoute.Authorization,
        args = args,
    )

    object Main : NavEvent(
        route = NavRoute.Main,
        clearBackStack = true,
    )

    object Welcome : NavEvent(
        route = NavRoute.Welcome,
        clearBackStack = true,
    )

    object Back : NavEvent()

}

object NavRoute {

    const val Main = "main"
    const val Authorization = "authorization"
    const val Welcome = "welcome"
    const val Splash = "splash"
}

sealed interface NavArguments : Serializable {

    data class Authorization(
        val isAuthorization: Boolean,
    ) : NavArguments
}
