package com.antrevs.core.presentation

import androidx.compose.runtime.Composable

interface DialogHolder {

    @Composable
    fun Dialog(
        text: String,
        action: () -> Unit,
        onDismissRequest: () -> Unit,
    )
}
