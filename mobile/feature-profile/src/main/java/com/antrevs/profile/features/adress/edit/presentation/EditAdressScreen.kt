package com.antrevs.profile.features.adress.edit.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.button.primary.PrimaryButton
import com.antrevs.view.ui.button.text.TextButtonState
import com.antrevs.view.ui.textfield.InputTextField
import com.antrevs.view.ui.textfield.InputTextFieldDefaults
import com.antrevs.view.ui.toolbar.Toolbar

@Composable
fun EditAddressScreen() {

    EditAddressScreenContent()
}

@Composable
private fun EditAddressScreenContent() {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1F),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                Toolbar(
                    modifier = Modifier.padding(
                        top = 8.dp,
                        start = 8.dp,
                        end = 8.dp,
                    ),
                    text = "Новый адресс",
                    onBackClick = {},
                )
            }
            item {
                AddressPartInputField(
                    label = "Город",
                    value = "Самара",
                    onValueChange = {},
                )
            }
            item {
                AddressPartInputField(
                    label = "Улица",
                    value = "Первомайская",
                    onValueChange = {},
                )
            }
            item {
                AddressPartInputField(
                    label = "Дом",
                    value = "18",
                    onValueChange = {},
                )
            }
            item {
                AddressPartInputField(
                    label = "Квартира",
                    value = "",
                    onValueChange = {},
                )
            }
            item {
                AddressPartInputField(
                    label = "Комментарий",
                    value = "",
                    onValueChange = {},
                )
            }
        }
        PrimaryButton(
            modifier = Modifier.padding(
                horizontal = 24.dp,
                vertical = 16.dp,
            ),
            state = TextButtonState.Text(
                text = "Сохранить",
            ),
            onClick = {},
        )
    }
}

@Composable
private fun AddressPartInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    InputTextField(
        value = value,
        label = label,
        onValueChange = onValueChange,
        hasBorder = false,
        colors = InputTextFieldDefaults.textFieldColors(
            isError = false,
            backgroundColor = Color.Transparent,
        )
    )
}