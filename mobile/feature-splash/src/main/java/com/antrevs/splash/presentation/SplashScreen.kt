package com.antrevs.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.antrevs.core.getApp
import com.antrevs.core.getViewModel
import com.antrevs.core.presentation.BaseScreen
import com.antrevs.core.presentation.DisposableWithLifecycle
import com.antrevs.splash.di.SplashComponent

@Composable
fun SplashScreen() {
    val context = LocalContext.current
    val component = remember { SplashComponent.init(context.getApp()) }
    val viewModel = getViewModel { component.viewModel }

    BaseScreen(viewModel)
    // TODO think about what can be doing this
    DisposableWithLifecycle {
        viewModel.onResume()
    }
}
