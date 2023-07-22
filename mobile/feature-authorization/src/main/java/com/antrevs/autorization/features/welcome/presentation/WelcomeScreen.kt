package com.antrevs.autorization.features.welcome.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.antrevs.authorization.R
import com.antrevs.autorization.features.welcome.di.WelcomeScreenComponent
import com.antrevs.core.getApp
import com.antrevs.core.getViewModel
import com.antrevs.core.presentation.BaseScreen
import com.antrevs.core.presentation.DisposableWithLifecycle
import com.antrevs.view.ui.button.primary.PrimaryButton
import com.antrevs.view.ui.button.text.TextButtonState

@Composable
fun WelcomeScreen() {
    val context = LocalContext.current
    val component = WelcomeScreenComponent.init(context.getApp())
    val viewModel = getViewModel { component.viewModel }
    BaseScreen(viewModel = viewModel) {
        WelcomeScreenContent(
            onAuthButtonClick = viewModel::onAuthButtonClick,
            onRegisterButtonClick = viewModel::onRegisterButtonClick,
        )
    }
    DisposableWithLifecycle {
        viewModel.onResume()
    }
}

@Composable
private fun WelcomeScreenContent(
    onAuthButtonClick: () -> Unit,
    onRegisterButtonClick: () -> Unit,
) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = com.antrevs.view.R.drawable.splash),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.weight(1F))
            PrimaryButton(
                modifier = Modifier.padding(horizontal = 16.dp),
                state = TextButtonState.Text(stringResource(id = R.string.welcome_register_button_text)),
                onClick = onRegisterButtonClick,
            )
            Spacer(Modifier.height(8.dp))
            PrimaryButton(
                modifier = Modifier.padding(horizontal = 16.dp),
                state = TextButtonState.Text(stringResource(id = R.string.welcome_auth_button_text)),
                onClick = onAuthButtonClick,
            )
            Spacer(Modifier.height(16.dp))
        }
    }

}
