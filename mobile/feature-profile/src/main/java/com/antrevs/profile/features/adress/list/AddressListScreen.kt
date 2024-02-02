package com.antrevs.profile.features.adress.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.button.primary.PrimaryButton
import com.antrevs.view.ui.button.text.TextButtonState
import com.antrevs.view.ui.primaryitem.PrimaryItem
import com.antrevs.view.ui.primaryitem.PrimaryItemState
import com.antrevs.view.ui.toolbar.Toolbar

@Composable
fun AddressListScreen() {

    AddressListScreenContent()
}

@Composable
private fun AddressListScreenContent() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
    ) {
        item {
            Toolbar(
                text = "Адреса",
                onBackClick = {},
            )
            Spacer(Modifier.height(16.dp))
        }
        drawAddressList()
        item {
            Spacer(Modifier.height(8.dp))
            PrimaryButton(
                modifier = Modifier.padding(horizontal = 24.dp),
                state = TextButtonState.Text(
                    text = "Новый адрес",
                ),
                onClick = {},
            )
        }
    }
}

private fun LazyListScope.drawAddressList() {
    item {
        PrimaryItem(
            state = PrimaryItemState.Text(
                title = "Молодогвардейская, 244",
                subtitle = "Домофона нет, звонить на телефон",
            ),
            titleTextStyle = DeliveryTheme.typography.title3,
            onClick = {

            },
            isArrowVisible = true,
        )
    }
    item {
        PrimaryItem(
            state = PrimaryItemState.Text(
                title = "Первомайская, 18",
            ),
            titleTextStyle = DeliveryTheme.typography.title3,
            onClick = {

            },
            isArrowVisible = true,
        )
    }
    item {
        PrimaryItem(
            state = PrimaryItemState.Text(
                title = "Невская, 9",
            ),
            titleTextStyle = DeliveryTheme.typography.title3,
            onClick = {

            },
            isArrowVisible = true,
        )
    }
}
