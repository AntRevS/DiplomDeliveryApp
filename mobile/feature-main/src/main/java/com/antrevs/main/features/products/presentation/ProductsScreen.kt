package com.antrevs.main.features.products.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.antrevs.core.getApp
import com.antrevs.core.getViewModel
import com.antrevs.core.presentation.BaseScreen
import com.antrevs.main.features.products.di.ProductsScreenComponent
import com.antrevs.main.features.products.presentation.entity.ProductCategory
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.icon.ic20.Search
import com.antrevs.view.icon.ic20.User
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.productitem.ProductItem
import com.antrevs.view.ui.text.Title
import com.antrevs.view.ui.text.TitleState
import com.antrevs.view.ui.textfield.InputTextField
import com.antrevs.view.ui.textfield.InputTextFieldDefaults
import com.antrevs.view.ui.toolbar.Toolbar

@Composable
fun ProductsScreen() {
    val context = LocalContext.current
    val app = context.getApp()

    val component = ProductsScreenComponent.init(app)
    val viewModel = getViewModel { component.viewModel.apply { onCreate() } }
    val viewState by viewModel.state.collectAsState()

    BaseScreen(viewModel) {
        ProductsScreenContent(
            viewState = viewState,
        )
    }
}

@Composable
private fun ProductsScreenContent(
    viewState: ProductsScreenState,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        item {
            Toolbar(
                modifier = Modifier.padding(16.dp),
                text = "Молодогвардейская, 244",
                rightContent = {
                    Icons.Common.PainterTintedIcon(
                        tint = DeliveryTheme.colors.primary,
                    ) { User }
                },
            )
        }
        drawProductListHeader()
        drawSearchField()
        viewState.products.forEach {
            drawCategory(
                category = it,
            )
        }
    }
}

private fun LazyListScope.drawProductListHeader() {
    item {
        Title(
            modifier = Modifier.padding(8.dp),
            state = TitleState.Text(
                text = "Доставка 15 минут",
            ),
        )
    }
}

private fun LazyListScope.drawSearchField() {
    item {
        InputTextField(
            modifier = Modifier.padding(8.dp),
            value = "",
            label = "Искать в доставке",
            onValueChange = {},
            isReadOnly = false,
            isEnabled = false,
            hasBorder = false,
            leadingIcon = {
                Icons.Common.PainterTintedIcon(
                    tint = DeliveryTheme.colors.primary,
                    size = 20.dp,
                ) {
                    Search
                }
            },
            colors = InputTextFieldDefaults.textFieldColors(
                isError = false,
                backgroundColor = DeliveryTheme.colors.secondaryVariant,
            )
        )
    }
}

private fun LazyListScope.drawCategory(
    category: ProductCategory,
) {
    item {
        Title(
            modifier = Modifier.padding(8.dp),
            state = TitleState.Text(category.name),
        )
    }
    item {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            category.products.forEach {
                item {
                    ProductItem(
                        state = it.state.copy(
                            productsCount = if (it.state.title.contains("burger", true)) {
                                1
                            } else {
                                0
                            }
                        ),
                        onPlusClick = {},
                        onMinusClick = {},
                    )
                }
            }
        }
    }
    item {
        Spacer(Modifier.height(16.dp))
    }
}