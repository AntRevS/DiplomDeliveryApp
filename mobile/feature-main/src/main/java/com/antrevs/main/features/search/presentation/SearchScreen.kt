package com.antrevs.main.features.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.antrevs.core.domain.Currency
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.Close
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.ui.divider.BlockDivider
import com.antrevs.view.ui.productitem.ProductItem
import com.antrevs.view.ui.productitem.ProductItemState
import com.antrevs.view.ui.textfield.InputTextField
import com.antrevs.view.ui.textfield.InputTextFieldDefaults

@Composable
fun SearchScreen() {

    SearchScreenContent()
}

@Composable
private fun SearchScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        InputTextField(
            value = "бургер",
            onValueChange = {},
            hasBorder = false,
            trailingIcon = {
                Icons.Common.PainterTintedIcon(
                    size = 32.dp,
                ) { Close }
            },
            colors = InputTextFieldDefaults.textFieldColors(
                isError = false,
                backgroundColor = Color.Transparent,
            )
        )
        BlockDivider()
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            drawPreview()
        }
    }
}

private fun LazyGridScope.drawPreview() {
    item {
        ProductItem(
            state = ProductItemState(
                title = "Бургер с курицей",
                imageUrl = "https://the-challenger.ru/wp-content/uploads/2016/10/foodnetwork.com_mediterranean_burger.jpg",
                badgeText = "120 ${Currency.RUB}",
                productsCount = 0,
            ),
            onPlusClick = {},
            onMinusClick = {},
        )
    }
    item {
        ProductItem(
            state = ProductItemState(
                title = "Чизбургер с говядиной",
                imageUrl = "https://cdn.bahroma1.ru/goods/grandburger_6366d239d48cc.jpg",
                badgeText = "140 ${Currency.RUB}",
                productsCount = 0,
            ),
            onPlusClick = {},
            onMinusClick = {},
        )
    }
}