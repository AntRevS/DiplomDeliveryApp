package com.antrevs.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.antrevs.core.LocalDialogHolder
import com.antrevs.core.LocalNavController
import com.antrevs.core.getApp
import com.antrevs.core.presentation.navigation.NavArguments
import com.antrevs.core.presentation.navigation.NavRoute
import com.antrevs.splash.presentation.SplashScreen
import com.antrevs.view.theme.DeliveryTheme
import java.io.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeliveryTheme {
                val navController = rememberNavController()
                val dialogHolder = getApp().uiComponent.getDialogHolder()
                CompositionLocalProvider(
                    LocalNavController provides navController,
                    LocalDialogHolder provides dialogHolder,
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = NavRoute.Splash,
                    ) {
                        composable(NavRoute.Splash) {
                            SplashScreen()
                        }
                    }
                }
            }
        }
    }

    private inline fun <reified T : NavArguments> NavGraphBuilder.composableWithArgs(
        route: String,
        crossinline content: @Composable (T) -> Unit,
    ) = composable(route) { backStack ->
        val backStackArgs = backStack.arguments
        val screenArgs = requireNotNull(backStackArgs?.requireSerializable<T>(route))
        content(screenArgs)
    }

    private inline fun <reified T : Serializable> Bundle.requireSerializable(key: String): T {
        return requireNotNull(getSerializable(key) as T) { "arguments for $key is null" }
    }
}
