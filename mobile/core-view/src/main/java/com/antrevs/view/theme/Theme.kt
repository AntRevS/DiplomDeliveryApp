package com.antrevs.view.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object DeliveryTheme {

    val colors: DeliveryAppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDeliveryColors.current

    val shapes: DeliveryAppShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalDeliveryShapes.current

    val typography: DeliveryAppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDeliveryTypography.current
}

val LocalDeliveryColors = staticCompositionLocalOf { DeliveryAppColors() }

val LocalDeliveryShapes = staticCompositionLocalOf { DeliveryAppShapes() }

val LocalDeliveryTypography = staticCompositionLocalOf { DeliveryAppTypography() }

@Composable
fun DeliveryTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalDeliveryColors provides DeliveryTheme.colors,
        LocalDeliveryShapes provides DeliveryTheme.shapes,
        LocalDeliveryTypography provides DeliveryTheme.typography,
        content = content,
    )
}