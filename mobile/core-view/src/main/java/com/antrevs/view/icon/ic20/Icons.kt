package com.antrevs.view.icon.ic20

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.antrevs.view.R
import com.antrevs.view.icon.Icons
import com.antrevs.view.theme.DeliveryTheme

@Composable
fun Icons.Common.PainterTintedIcon(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    tint: Color = DeliveryTheme.colors.primary,
    painter: @Composable Icons.Common.() -> Painter,
) = Icon(
    modifier = modifier.size(size),
    painter = painter.invoke(this),
    contentDescription = null,
    tint = tint,
)

val Icons.Common.ChevronDown: Painter
    @Composable get() = painterResource(id = R.drawable.ic_16_chevron_down)

val Icons.Common.Search: Painter
    @Composable get() = painterResource(id = R.drawable.ic_16_search)

val Icons.Common.Plus: Painter
    @Composable get() = painterResource(id = R.drawable.ic_20_plus)

val Icons.Common.Minus: Painter
    @Composable get() = painterResource(id = R.drawable.ic_20_minus)

val Icons.Common.Close: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_close)

val Icons.Common.Phone: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_phone)

val Icons.Common.Mail: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_mail)

val Icons.Common.ChevronRight: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_chevron_right)

val Icons.Common.User: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_user)

val Icons.Common.Home: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_home)

val Icons.Common.Settings: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_settings)

val Icons.Common.Clock: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_clock)

val Icons.Common.Back: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_arrow_back)

val Icons.Common.BellBing: Painter
    @Composable get() = painterResource(id = R.drawable.ic_24_bell_ring)
