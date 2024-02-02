package com.antrevs.profile.features.settings.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.antrevs.profile.R
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.Mail
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.icon.ic20.Phone
import com.antrevs.view.icon.ic20.User
import com.antrevs.view.layout.BottomSheet
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.button.primary.PrimaryButton
import com.antrevs.view.ui.button.text.TextButton
import com.antrevs.view.ui.button.text.TextButtonState
import com.antrevs.view.ui.divider.BlockDivider
import com.antrevs.view.ui.primaryitem.PrimaryItem
import com.antrevs.view.ui.primaryitem.PrimaryItemState
import com.antrevs.view.ui.text.Title
import com.antrevs.view.ui.text.TitleState
import com.antrevs.view.ui.textfield.InputTextField
import com.antrevs.view.ui.textfield.InputTextFieldDefaults
import com.antrevs.view.ui.toolbar.Toolbar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileSettingsScreen() {

    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    ProfileSettingsScreenContent(
        onClick = {
            coroutineScope.launch {
                state.animateTo(ModalBottomSheetValue.Expanded)
            }
        },
    )
    EditDialog(
        titleResId = R.string.setting_name,
        state = state,
        value = "Антон",
        onValueChange = {},
    )
}

@ExperimentalMaterialApi
@Composable
private fun EditDialog(
    @StringRes titleResId: Int,
    state: ModalBottomSheetState,
    value: String,
    onValueChange: (String) -> Unit,
) {
    BottomSheet(state = state) {
        Column(
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InputTextField(
                value = value,
                label = stringResource(id = titleResId),
                onValueChange = onValueChange,
                hasBorder = false,
                textStyle = DeliveryTheme.typography.body2.copy(
                    textAlign = TextAlign.Center,
                ),
                labelTextStyle = DeliveryTheme.typography.body0.copy(
                    textAlign = TextAlign.Center,
                ),
                colors = InputTextFieldDefaults.textFieldColors(
                    isError = false,
                    backgroundColor = Color.Transparent,
                )
            )
        }
        PrimaryButton(
            modifier = Modifier.padding(24.dp),
            state = TextButtonState.Text(
                text = "Сохранить",
            ),
            onClick = {},
        )
    }
}

@Composable
private fun ProfileSettingsScreenContent(
    onClick: () -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Toolbar(
                text = "Настройки",
                onBackClick = {},
            )
        }
        item {
            Title(
                modifier = Modifier.padding(vertical = 16.dp),
                state = TitleState.Text("Профиль"),
            )
            BlockDivider()
        }
        item {
            SettingsButton(
                text = "+7 987 654 32 10",
                icon = { SettingsButtonIcon { Phone } },
                onClick = onClick
            )
        }
        item {
            SettingsButton(
                text = "Антон",
                icon = { SettingsButtonIcon { User } },
                onClick = {}
            )
        }
        item {
            SettingsButton(
                text = "Добавить почту",
                icon = { SettingsButtonIcon { Mail } },
                onClick = {}
            )
        }
        drawButtonsBlock()
    }
}

private fun LazyListScope.drawButtonsBlock() {
    item {
        Spacer(Modifier.height(32.dp))
        PrimaryButton(
            modifier = Modifier.padding(horizontal = 24.dp),
            color = DeliveryTheme.colors.secondaryVariant,
            textColor = DeliveryTheme.colors.primary,
            state = TextButtonState.Text(
                text = "Выйти",
            ),
            onClick = {},
        )
    }
    item {
        TextButton(
            state = TextButtonState.Text("Удалить аккаунт"),
            onClick = {},
        )
    }
}

@Composable
private fun SettingsButton(
    text: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
) {
    PrimaryItem(
        state = PrimaryItemState.Text(text),
        leftContent = icon,
        onClick = onClick,
        titleTextStyle = DeliveryTheme.typography.body2,
        isArrowVisible = true,
    )
    BlockDivider()
}

@Composable
private fun SettingsButtonIcon(
    painter: @Composable Icons.Common.() -> Painter,
) {
    Icons.Common.PainterTintedIcon(
        modifier = Modifier.padding(vertical = 16.dp),
        painter = painter,
    )
    Spacer(modifier = Modifier.width(8.dp))
}