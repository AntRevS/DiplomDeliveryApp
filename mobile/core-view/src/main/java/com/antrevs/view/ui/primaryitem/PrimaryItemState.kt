package com.antrevs.view.ui.primaryitem

sealed interface PrimaryItemState {

    data class Text(
        val title: String,
        val subtitle: String? = null,
    ): PrimaryItemState
}
