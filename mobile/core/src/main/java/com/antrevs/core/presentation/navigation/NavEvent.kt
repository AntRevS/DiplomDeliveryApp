package com.antrevs.core.presentation.navigation

import java.io.Serializable

sealed class NavEvent(
    val route: String? = null,
    val clearBackStack: Boolean = false,
    open val args: NavArguments? = null,
) {

    object Splash : NavEvent(route = NavRoute.Splash)

    object Back : NavEvent()

}

object NavRoute {

    const val Splash = "splash"
}

sealed interface NavArguments : Serializable {
    
}

