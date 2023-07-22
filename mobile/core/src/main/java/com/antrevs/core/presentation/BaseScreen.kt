package com.antrevs.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.antrevs.core.LocalDialogHolder
import com.antrevs.core.LocalNavController
import com.antrevs.core.presentation.navigation.navigate
import com.antrevs.core.presentation.navigation.navigateAndClean

private typealias ErrorDialogState = Pair<String, () -> Unit>

@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    content: (@Composable () -> Unit)? = null,
) {
    val context = LocalContext.current
    val navController = LocalNavController.current
    val dialogHolder = LocalDialogHolder.current

    var alertDialogState by remember { mutableStateOf<ErrorDialogState?>(null) }

    alertDialogState?.let {
        dialogHolder.Dialog(
            text = it.first,
            action = it.second,
            onDismissRequest = it.second,
        )
    }

    content?.invoke()

    viewModel.alertEvent.CollectionWithLifecycle { event ->
        alertDialogState = ErrorDialogState(
            first = event.textRes?.let {
                context.getString(it)
            } ?: event.text.orEmpty(),
            second = {
                alertDialogState = null
                event.action()
            },
        )
    }
    viewModel.navigationEvent.CollectionWithLifecycle { event ->
        event.route?.let { route ->
            if (event.clearBackStack) {
                navController.navigateAndClean(route, event.args)
            } else {
                navController.navigate(route, event.args)
            }
        } ?: navController.popBackStack()
    }
}
