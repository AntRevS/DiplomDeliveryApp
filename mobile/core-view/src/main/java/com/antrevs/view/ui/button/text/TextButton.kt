package com.antrevs.view.ui.button.text

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.Back
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.loader.Loader

sealed interface TextButtonState {

    data class Text(val text: String): TextButtonState

    object Loading: TextButtonState
}

@Composable
fun TextButton(
    state: TextButtonState,
    onClick: () -> Unit,
    leftIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent,
        ),
        border = null,
        onClick = onClick,
    ) {
        when (state) {
            is TextButtonState.Text -> {
                leftIcon?.invoke()
                Text(
                    text = state.text,
                    style = DeliveryTheme.typography.body1,
                    color = DeliveryTheme.colors.brand,
                )
            }
            is TextButtonState.Loading -> {
                Loader()
            }
        }
    }
}

@Preview
@Composable
private fun TextButtonPreview() {
    DeliveryTheme {
        TextButton(
            state = TextButtonState.Text("Кнопка"),
            onClick = {},
            leftIcon = {
                Icons.Common.PainterTintedIcon(
                    tint = DeliveryTheme.colors.primary,
                ) {
                    Back
                }
            },
        )
    }
}