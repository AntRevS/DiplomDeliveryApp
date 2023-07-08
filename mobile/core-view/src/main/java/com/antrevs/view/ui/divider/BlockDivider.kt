package com.antrevs.view.ui.divider

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.antrevs.view.theme.DeliveryTheme

@Composable
fun BlockDivider() {
    Divider(
        thickness = 0.5.dp,
        color = DeliveryTheme.colors.secondaryVariant,
    )
}
