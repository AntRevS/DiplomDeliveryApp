package com.antrevs.view.ui.button.primary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.button.text.TextButtonState
import com.antrevs.view.ui.loader.Loader

@Composable
fun PrimaryButton(
    state: TextButtonState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = DeliveryTheme.colors.brand,
    textColor: Color = Color.White,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(45.dp),
        shape = CircleShape,
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
        ),
        onClick = onClick,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
        ),
    ) {
        when (state) {
            is TextButtonState.Text -> {
                Text(
                    text = state.text,
                    style = DeliveryTheme.typography.body1,
                    color = textColor,
                )
            }
            is TextButtonState.Loading -> {
                Loader(color = Color.White)
            }
        }
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    DeliveryTheme {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            PrimaryButton(
                state = TextButtonState.Text("Выбрать адрес доставки 23432432 " +
                        "4234 234 23 234234 234 234 234 234 234 234 234 23 423"),
                onClick = {},
            )
            PrimaryButton(
                state = TextButtonState.Text("Войти"),
                color = DeliveryTheme.colors.secondaryVariant.copy(0.5F),
                onClick = {},
            )
            PrimaryButton(
                state = TextButtonState.Loading,
                color = DeliveryTheme.colors.secondaryVariant.copy(0.5F),
                onClick = {},
            )
        }
    }
}