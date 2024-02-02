package com.antrevs.main.features.orderdialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.antrevs.core.domain.Currency
import com.antrevs.view.layout.BottomSheet
import com.antrevs.view.ui.button.primary.PrimaryButton
import com.antrevs.view.ui.button.text.TextButtonState
import com.antrevs.view.ui.primaryitem.PrimaryItem
import com.antrevs.view.ui.primaryitem.PrimaryItemState
import com.antrevs.view.ui.productitem.ProductItem
import com.antrevs.view.ui.productitem.ProductItemState
import com.antrevs.view.ui.text.Title
import com.antrevs.view.ui.text.TitleState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderDialog(
    state: ModalBottomSheetState,
) {
    BottomSheet(state = state) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item {
                PrimaryItem(
                    state = PrimaryItemState.Text(
                        title = "",
                        subtitle = "Будем через 15 минут",
                    )
                )
                Title(
                    state = TitleState.Text("Молодогвардейская, 244"),
                )
            }
            item {
                Row {
                    ProductItem(
                        state = ProductItemState(
                            title = "Бургер с курицей",
                            imageUrl = "https://the-challenger.ru/wp-content/uploads/2016/10/foodnetwork.com_mediterranean_burger.jpg",
                            badgeText = "120 ${Currency.RUB}",
                            productsCount = 1,
                        ),
                        onPlusClick = {},
                        onMinusClick = {},
                        isVertical = false,
                    )
                    ProductItem(
                        state = ProductItemState(
                            title = "Чизбургер с курицей",
                            imageUrl = "https://cdn.bahroma1.ru/goods/grandburger_6366d239d48cc.jpg",
                            badgeText = "140 ${Currency.RUB}",
                            productsCount = 1,
                        ),
                        onPlusClick = {},
                        onMinusClick = {},
                        isVertical = false,
                    )
                }
            }
            item {
                PrimaryItem(
                    state = PrimaryItemState.Text(
                        title = "",
                        subtitle = "Итого",
                    ),
                    textAlign = TextAlign.Center,
                )
                Title(
                    state = TitleState.Text("260 ${Currency.RUB}"),
                    textAlign = TextAlign.Center,
                )
            }
            item {
                PrimaryButton(
                    state = TextButtonState.Text("Заказать"),
                    onClick = {},
                )
            }
        }
    }
}