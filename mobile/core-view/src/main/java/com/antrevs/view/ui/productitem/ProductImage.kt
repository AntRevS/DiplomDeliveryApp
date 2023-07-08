package com.antrevs.view.ui.productitem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.antrevs.view.theme.DeliveryTheme

enum class ProductImageSize(val size: Dp) {
    LARGE(240.dp),
    MEDIUM(160.dp),
    SMALL(80.dp),
}

@Composable
fun ProductImage(
    url: String?,
    size: ProductImageSize,
    modifier: Modifier = Modifier,
    overlayText: String? = null,
    errorContent: @Composable () -> Unit = {},
) {
    Box(
        modifier = modifier
            .size(size.size)
            .clip(DeliveryTheme.shapes.large)
            .background(DeliveryTheme.colors.secondaryVariant),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            model = url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            onLoading = {},
            onError = {},
        )
        overlayText?.let {
            ProductImageOverlay(overlayText = it)
        }
    }
}

@Composable
private fun ProductImageOverlay(
    overlayText: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeliveryTheme.colors.secondaryVariant.copy(0.7F)),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = overlayText,
            style = DeliveryTheme.typography.title0,
            color = Color.White,
        )
    }
}
