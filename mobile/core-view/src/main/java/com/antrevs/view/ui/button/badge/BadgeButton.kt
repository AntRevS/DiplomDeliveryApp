package com.antrevs.view.ui.button.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.Minus
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.icon.ic20.Plus
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.utils.clickableWithRippleEffect

@Composable
fun BadgeButton(
    text: String,
    modifier: Modifier = Modifier,
    contentColor: Color = DeliveryTheme.colors.primary,
    onLeftIconClick: (() -> Unit)? = null,
    onRightIconClick: (() -> Unit)? = null,
    rightIcon: @Composable (Icons.Common.() -> Painter)? = null,
    leftIcon: @Composable (Icons.Common.() -> Painter)? = null,
) {
    val endPadding = if (rightIcon != null) {
        0.dp
    } else {
        8.dp
    }
    val startPadding = if (leftIcon != null) {
        0.dp
    } else {
        8.dp
    }
    BadgeButtonContainer(
        modifier = modifier,
        startPadding = startPadding,
        endPadding = endPadding,
    ) {
        leftIcon?.let {
            BadgeButtonIcon(
                onClick = onLeftIconClick,
                tint = contentColor,
                painter = it,
            )
        }
        Text(
            text = text,
            style = DeliveryTheme.typography.body0,
            color = contentColor,
        )
        rightIcon?.let {
            BadgeButtonIcon(
                onClick = onRightIconClick,
                tint = contentColor,
                painter = it,
            )
        }
    }
}

@Composable
private fun BadgeButtonIcon(
    onClick: (() -> Unit)?,
    tint: Color,
    painter: @Composable Icons.Common.() -> Painter,
) {
    val modifier = Modifier.clip(CircleShape)

    Icons.Common.PainterTintedIcon(
        modifier = onClick?.let {
            modifier.clickableWithRippleEffect(onClick)
        } ?: modifier,
        tint = tint,
        painter = painter,
    )
}

@Composable
private fun BadgeButtonContainer(
    modifier: Modifier,
    startPadding: Dp,
    endPadding: Dp,
    content: @Composable RowScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .height(22.dp)
            .clip(DeliveryTheme.shapes.large)
            .background(DeliveryTheme.colors.secondaryVariant),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier.padding(
                start = startPadding,
                end = endPadding,
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            content = content,
        )
    }
}

@Preview(name = "BadgeButton")
@Composable
private fun BadgeButtonPreview() {
    DeliveryTheme {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            BadgeButton(
                text = "114 $",
                onRightIconClick = {},
            )
            BadgeButton(
                text = "114 $",
                contentColor = DeliveryTheme.colors.brand,
                rightIcon = { Plus },
                onRightIconClick = {},
            )
            BadgeButton(
                text = "114 $",
                contentColor = DeliveryTheme.colors.brand,
                rightIcon = { Plus },
                leftIcon = { Minus },
                onRightIconClick = {},
                onLeftIconClick = {},
            )
        }
    }
}