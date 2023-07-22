package com.antrevs.ui.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.antrevs.core.presentation.DialogHolder
import com.antrevs.ui.R
import com.antrevs.view.theme.DeliveryTheme
import com.antrevs.view.ui.button.text.TextButton
import com.antrevs.view.ui.button.text.TextButtonState
import javax.inject.Inject

class DialogHolderImpl @Inject constructor() : DialogHolder {

    @Composable
    override fun Dialog(
        text: String,
        action: () -> Unit,
        onDismissRequest: () -> Unit,
    ) {
        AlertDialog(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = stringResource(id = R.string.common_attention),
                    style = DeliveryTheme.typography.title2,
                    color = DeliveryTheme.colors.primary,
                )
            },
            text = {
                Text(
                    text = text,
                    style = DeliveryTheme.typography.body2,
                    color = DeliveryTheme.colors.secondary,
                )
            },
            onDismissRequest = onDismissRequest,
            buttons = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd,
                ) {
                    TextButton(
                        modifier = Modifier.padding(end = 8.dp),
                        state = TextButtonState.Text(
                            text = stringResource(id = R.string.common_ok),
                        ),
                        onClick = action,
                    )
                }
            },
        )
    }
}
