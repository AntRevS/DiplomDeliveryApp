package com.antrevs.view.ui.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.antrevs.view.theme.DeliveryTheme

sealed interface TitleState {

    data class Text(val text: String): TitleState
}


@Composable
fun Title(
    state: TitleState,
    textAlign: TextAlign = TextAlign.Start,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when (state) {
            is TitleState.Text -> {
                TitleWithTextContent(
                    title = state.text,
                    textAlign = textAlign,
                )
            }
        }
    }
}

@Composable
private fun RowScope.TitleWithTextContent(
    title: String,
    textAlign: TextAlign,
) {
    Column(
        modifier = Modifier.weight(1F),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = textAlign,
            style = DeliveryTheme.typography.title1,
            color = DeliveryTheme.colors.primary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
