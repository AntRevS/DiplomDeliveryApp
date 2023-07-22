package com.antrevs.autorization.features.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.antrevs.authorization.R
import com.antrevs.autorization.features.auth.di.AuthScreenComponent
import com.antrevs.autorization.features.auth.presentation.state.AuthScreenState
import com.antrevs.core.getApp
import com.antrevs.core.getViewModel
import com.antrevs.core.presentation.BaseScreen
import com.antrevs.view.ui.button.primary.PrimaryButton
import com.antrevs.view.ui.button.text.TextButtonState
import com.antrevs.view.ui.textfield.InputTextField
import com.antrevs.view.ui.textfield.TextFormat
import com.antrevs.view.ui.toolbar.Toolbar

@Composable
fun AuthScreen(isAuth: Boolean) {
    val component = getComponent(isAuth = isAuth)
    val viewModel = getViewModel {
        component.viewModel.apply { onCreate() }
    }
    val viewState by viewModel.state.collectAsState()
    BaseScreen(viewModel = viewModel) {
        AuthScreenContent(
            viewState = viewState,
            onBackClick = viewModel::onBackClick,
            onPhoneNumberValueChange = viewModel::onPhoneNumberValueChange,
            onPasswordValueChange = viewModel::onPasswordValueChange,
            onBottomButtonClick = viewModel::onBottomButtonClick
        )
    }
}

@Composable
private fun getComponent(isAuth: Boolean): AuthScreenComponent {
    val context = LocalContext.current
    return remember {
        AuthScreenComponent.init(
            app = context.getApp(),
            isAuth = isAuth,
        )
    }
}

@Composable
private fun AuthScreenContent(
    viewState: AuthScreenState,
    onBackClick: () -> Unit,
    onPhoneNumberValueChange: (String) -> Unit,
    onPasswordValueChange: (String) -> Unit,
    onBottomButtonClick: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        item {
            Toolbar(
                text = stringResource(
                    id = if (viewState.isAuth) {
                        R.string.auth_title
                    } else {
                        R.string.register_title
                    },
                ),
                onBackClick = onBackClick,
            )
        }
        item {
            InputTextField(
                value = viewState.phoneNumber.value,
                isError = viewState.phoneNumber.isError,
                onValueChange = onPhoneNumberValueChange,
                label = stringResource(id = R.string.auth_login_hint),
                textFormat = TextFormat.PhoneNumber,
            )
        }
        item {
            InputTextField(
                value = viewState.password.value,
                isError = viewState.password.isError,
                onValueChange = onPasswordValueChange,
                textFormat = TextFormat.Password,
                label = stringResource(id = R.string.auth_password_hint),
            )
        }
        item {
            PrimaryButton(
                modifier = Modifier.padding(horizontal = 8.dp),
                state = if (!viewState.isLoading) {
                    TextButtonState.Text(
                        text = stringResource(
                            id = if (viewState.isAuth) {
                                R.string.auth_button_text
                            } else {
                                R.string.register_button_text
                            },
                        ),
                    )
                } else {
                    TextButtonState.Loading
                },
                onClick = onBottomButtonClick,
            )
        }
    }
}