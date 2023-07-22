package com.antrevs.core.presentation.navigation

import java.io.Serializable

sealed class NavEvent(
    val route: String? = null,
    val clearBackStack: Boolean = false,
    open val args: NavArguments? = null,
) {

    object Welcome : NavEvent(
        route = NavRoute.Welcome,
        clearBackStack = true,
    )

    object Back : NavEvent()

}

object NavRoute {

    const val Welcome = "welcome"
    const val Splash = "splash"
}
