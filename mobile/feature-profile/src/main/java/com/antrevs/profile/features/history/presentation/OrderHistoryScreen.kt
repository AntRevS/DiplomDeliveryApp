package com.antrevs.profile.features.history.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.antrevs.core.domain.Currency
import com.antrevs.view.layout.BottomSheet
import com.antrevs.view.ui.divider.BlockDivider
import com.antrevs.view.ui.primaryitem.PrimaryItem
import com.antrevs.view.ui.primaryitem.PrimaryItemState
import com.antrevs.view.ui.text.Title
import com.antrevs.view.ui.text.TitleState
import com.antrevs.view.ui.toolbar.Toolbar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderHistoryScreen() {

    val state = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    
    OrderHistoryScreenContent(
        onClick = {
            coroutineScope.launch {
                state.animateTo(ModalBottomSheetValue.Expanded)
            }
        },
    )
    OrderDetailsDialog(state = state)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun OrderDetailsDialog(
    state: ModalBottomSheetState,
) {
    BottomSheet(state = state) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                Title(state = TitleState.Text("Молодогвардейская, 244 · 14.05.2023"))
            }
            item {
                BlockDivider()
            }
            item {
                ProductOrderItem(
                    address = "Бургер с курицей",
                    price = "120 ${Currency.RUB}",
                )
            }
        }
    }
}

@Composable
private fun OrderHistoryScreenContent(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Toolbar(
            modifier = Modifier.padding(16.dp),
            text = "Заказы",
            onBackClick = {},
        )
        BlockDivider()
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                OrderItem(
                    address = "Молодогвардейская, 244",
                    price = "120 ${Currency.RUB}",
                    date = "14.05.2023",
                    onClick = onClick,
                )
            }
            item {
                BlockDivider()
            }
            item {
                OrderItem(
                    address = "Молодогвардейская, 244",
                    price = "240 ${Currency.RUB}",
                    date = "12.05.2023",
                    onClick = onClick,
                )
            }
        }
    }
}

@Composable
private fun OrderItem(
    address: String,
    price: String,
    date: String,
    onClick: () -> Unit,
) {
    PrimaryItem(
        state = PrimaryItemState.Text(
            title = address,
            subtitle = "$price · ${date}"
        ),
        onClick = onClick,
        isArrowVisible = true
    )
}

@Composable
private fun ProductOrderItem(
    address: String,
    price: String,
    onClick: (() -> Unit)? = null,
) {
    PrimaryItem(
        state = PrimaryItemState.Text(
            title = address,
            subtitle = price
        ),
        onClick = onClick,
        isArrowVisible = onClick != null
    )
}