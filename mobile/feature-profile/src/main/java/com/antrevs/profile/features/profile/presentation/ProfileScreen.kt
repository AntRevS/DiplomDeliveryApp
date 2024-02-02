package com.antrevs.profile.features.profile.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.antrevs.view.icon.Icons
import com.antrevs.view.icon.ic20.Clock
import com.antrevs.view.icon.ic20.Home
import com.antrevs.view.icon.ic20.PainterTintedIcon
import com.antrevs.view.icon.ic20.Settings
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.divider.BlockDivider
import com.antrevs.view.ui.primaryitem.PrimaryItem
import com.antrevs.view.ui.primaryitem.PrimaryItemState
import com.antrevs.view.ui.toolbar.Toolbar

@Composable
fun ProfileScreen() {

    ProfileScreenContent()
}

@Composable
private fun ProfileScreenContent() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
    ) {
        item {
            Toolbar(
                text = "Профиль",
                onBackClick = {},
            )
        }
        item {
            PrimaryItem(
                modifier = Modifier.padding(vertical = 16.dp),
                state = PrimaryItemState.Text(
                    title = "Антон",
                    subtitle = "+7 987 654 32 10",
                ),
            )
            BlockDivider()
        }
        item {
            ProfileButton(
                text = "Заказы",
                icon = { ProfileButtonIcon { Clock } },
                onClick = {}
            )
        }
        item {
            ProfileButton(
                text = "Адреса",
                icon = { ProfileButtonIcon { Home } },
                onClick = {}
            )
        }
        item {
            ProfileButton(
                text = "Настройки",
                icon = { ProfileButtonIcon { Settings } },
                onClick = {}
            )
        }
    }
}

@Composable
private fun ProfileButton(
    text: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
) {
    PrimaryItem(
        state = PrimaryItemState.Text(text),
        leftContent = icon,
        onClick = onClick,
    )
    BlockDivider()
}

@Composable
private fun ProfileButtonIcon(
    painter: @Composable Icons.Common.() -> Painter,
) {
    Icons.Common.PainterTintedIcon(
        modifier = Modifier.padding(vertical = 16.dp),
        size = 32.dp,
        painter = painter,
    )
    Spacer(modifier = Modifier.width(8.dp))
}