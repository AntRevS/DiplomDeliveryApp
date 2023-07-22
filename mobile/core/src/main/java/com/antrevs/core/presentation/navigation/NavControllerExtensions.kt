package com.antrevs.core.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import java.io.Serializable

internal fun NavController.navigate(
    route: String,
    args: Serializable?,
) {
    navigate(route)

    requireNotNull(currentBackStackEntry?.arguments).apply {
        putSerializable(route, args)
    }
}

internal fun NavController.navigate(
    route: String,
    args: Serializable?,
    builder: NavOptionsBuilder.() -> Unit
) {
    navigate(
        route = route,
        builder = builder,
    )

    requireNotNull(currentBackStackEntry?.arguments).apply {
        putSerializable(route, args)
    }
}

internal fun NavController.navigateAndClean(route: String, args: Serializable?) {
    navigate(route = route, args = args) {
        popUpTo(graph.startDestinationId) { inclusive = true }
    }
    graph.setStartDestination(route)
}
