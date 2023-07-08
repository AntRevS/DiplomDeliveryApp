package com.antrevs.view.ui.loader

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antrevs.view.theme.DeliveryTheme

@Composable
fun Loader(
    color: Color = DeliveryTheme.colors.brand,
) {
    CircularProgressIndicator(
        modifier = Modifier.size(24.dp),
        color = color,
    )
}

@Preview
@Composable
private fun LoaderPreview() {
    DeliveryTheme {
        Loader()
    }
}
