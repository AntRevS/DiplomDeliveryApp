package com.antrevs.view.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.antrevs.view.theme.DeliveryTheme

fun Modifier.optional(
    predicate: () -> Boolean,
    onTrue: (Modifier) -> Modifier,
) = if (predicate()) {
    onTrue(this)
} else {
    this
}

fun Modifier.clickableWithRippleEffect(
    onClick: () -> Unit,
) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(
            color = DeliveryTheme.colors.secondaryVariant,
        ),
        onClick = onClick,
    )
}
