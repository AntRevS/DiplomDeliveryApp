package com.antrevs.view.ui.toolbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.Back
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.utils.clickableWithRippleEffect

@Composable
fun Toolbar(
    text: String,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    rightContent: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        onBackClick?.let { onClick ->
            Icons.Common.PainterTintedIcon(
                modifier = Modifier.clickableWithRippleEffect { onClick() },
                tint = DeliveryTheme.colors.primary,
            ) { Back }
            Spacer(Modifier.width(8.dp))
        }
        Text(
            modifier = Modifier.weight(1F),
            text = text,
            style = DeliveryTheme.typography.title1,
            color = DeliveryTheme.colors.primary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        rightContent?.let {
            Spacer(Modifier.width(8.dp))
            it.invoke()
        }
    }
}
