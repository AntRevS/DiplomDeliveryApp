package com.antrevs.view.layout

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable

@ExperimentalMaterialApi
@Composable
fun BottomSheet(
    state: ModalBottomSheetState,
    content: @Composable ColumnScope.() -> Unit,
) {
    ModalBottomSheetLayout(
        sheetState = state,
        sheetContent = content,
        content = {},
    )
}
