package com.antrevs.view.ui.productitem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antrevs.view.icon.ic20.Minus
import com.antrevs.view.icon.ic20.Plus
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.button.badge.BadgeButton

data class ProductItemState(
    val title: String,
    val imageUrl: String?,
    val badgeText: String,
    val productsCount: Int,
)

@Composable
fun ProductItem(
    state: ProductItemState,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
    isVertical: Boolean = true,
) {
    val isProductsEmpty = (state.productsCount == 0)
    if (isVertical) {
        VerticalProductItem(
            state = state,
            onPlusClick = onPlusClick,
            onMinusClick = onMinusClick,
            isProductsEmpty = isProductsEmpty,
            modifier = modifier,
        )
    } else {
        HorizontalProductItem(
            state = state,
            onPlusClick = onPlusClick,
            onMinusClick = onMinusClick,
            isProductsEmpty = isProductsEmpty,
            modifier = modifier,
        )
    }
}

@Composable
private fun HorizontalProductItem(
    state: ProductItemState,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    isProductsEmpty: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .widthIn(max = 240.dp)
            .height(80.dp),
    ) {
        ProductImage(
            url = state.imageUrl,
            size = ProductImageSize.SMALL,
            overlayText = state.productsCount.takeIf { !isProductsEmpty }?.toString(),
        )
        Spacer(Modifier.width(8.dp))
        Column {
            Box(modifier = Modifier.weight(1F)) {
                ProductItemText(
                    title = state.title,
                )
            }
            ProductItemControl(
                text = state.badgeText,
                onPlusClick = onPlusClick,
                onMinusClick = onMinusClick,
                isControlsVisible = !isProductsEmpty,
            )
        }
        Spacer(Modifier.width(8.dp))
    }
}

@Composable
private fun VerticalProductItem(
    state: ProductItemState,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    isProductsEmpty: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(160.dp),
    ) {
        ProductImage(
            url = state.imageUrl,
            size = ProductImageSize.MEDIUM,
            overlayText = state.productsCount.takeIf { !isProductsEmpty }?.toString(),
        )
        ProductItemText(
            title = state.title,
        )
        Spacer(Modifier.height(8.dp))
        ProductItemControl(
            text = state.badgeText,
            onPlusClick = onPlusClick,
            onMinusClick = onMinusClick,
            isControlsVisible = !isProductsEmpty,
        )
    }
}

@Composable
private fun ProductItemText(
    title: String,
) {
    Text(
        text = title,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = DeliveryTheme.typography.body0,
        color = DeliveryTheme.colors.primary,
    )
}

@Composable
private fun ProductItemControl(
    text: String,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    isControlsVisible: Boolean,
) {
    BadgeButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
        text = text,
        contentColor = DeliveryTheme.colors.brand,
        onRightIconClick = onPlusClick,
        onLeftIconClick = onMinusClick,
        rightIcon = if (isControlsVisible) {
            { Plus }
        } else {
            null
        },
        leftIcon = if (isControlsVisible) {
            { Minus }
        } else {
            null
        },
    )
}

@Preview(name = "ProductItem")
@Composable
private fun ProductItemPreview() {
    DeliveryTheme {
        ProductItem(
            state = ProductItemState(
                title = "Кола",
                imageUrl = "",
                badgeText = "100 $",
                productsCount = 0,
            ),
            onMinusClick = {},
            onPlusClick = {},
        )
    }
}
