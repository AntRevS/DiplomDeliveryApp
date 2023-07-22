package com.antrevs.core.presentation.event

import androidx.annotation.StringRes

data class AlertEvent(
    val text: String? = null,
    @StringRes val textRes: Int? = null,
    val action: () -> Unit,
)
