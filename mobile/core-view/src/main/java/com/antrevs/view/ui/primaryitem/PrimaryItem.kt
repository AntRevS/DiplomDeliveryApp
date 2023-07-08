package com.antrevs.view.ui.primaryitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.ChevronRight
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.utils.clickableWithRippleEffect
import com.antrevs.view.utils.optional

@Composable
fun PrimaryItem(
    state: PrimaryItemState,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    titleTextStyle: TextStyle = DeliveryTheme.typography.title1,
    subtitleTextStyle: TextStyle = DeliveryTheme.typography.body2,
    leftContent: ((@Composable () -> Unit))? = null,
    isArrowVisible: Boolean = false,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .optional(
                predicate = { onClick != null },
                onTrue = {
                    it.clickableWithRippleEffect { onClick?.invoke() }
                },
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when (state) {
            is PrimaryItemState.Text -> {
                TextContent(
                    title = state.title,
                    subtitle = state.subtitle,
                    textAlign = textAlign,
                    titleTextStyle = titleTextStyle,
                    subtitleTextStyle = subtitleTextStyle,
                    leftContent = leftContent,
                    isArrowVisible = isArrowVisible,
                )
            }
        }
    }
}

@Composable
private fun RowScope.TextContent(
    title: String,
    subtitle: String?,
    textAlign: TextAlign,
    titleTextStyle: TextStyle,
    subtitleTextStyle: TextStyle,
    leftContent: ((@Composable () -> Unit))?,
    isArrowVisible: Boolean,
) {
    leftContent?.invoke()
    Column(
        modifier = Modifier.weight(1F),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            style = titleTextStyle,
            textAlign = textAlign,
            color = DeliveryTheme.colors.primary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        subtitle?.let {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = it,
                style = subtitleTextStyle,
                textAlign = textAlign,
                color = DeliveryTheme.colors.secondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
    if (isArrowVisible) {
        Icons.Common.PainterTintedIcon(
            size = 32.dp,
            tint = DeliveryTheme.colors.secondary,
        ) { ChevronRight }
    }
}