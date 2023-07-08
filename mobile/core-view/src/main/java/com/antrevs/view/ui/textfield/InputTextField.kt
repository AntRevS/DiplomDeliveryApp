package com.antrevs.view.ui.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.antrevs.view.R
import com.antrevs.view.theme.DeliveryTheme

object InputTextFieldDefaults {

    @Composable
    fun textFieldColors(
        isError: Boolean,
        textColor: Color = DeliveryTheme.colors.primary,
        cursorColor: Color = DeliveryTheme.colors.brand,
        backgroundColor: Color = Color.White,
    ): TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = textColor.getColorOrError(isError = isError),
        cursorColor = cursorColor,
        errorCursorColor = DeliveryTheme.colors.error,
        backgroundColor = backgroundColor,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        focusedLabelColor = DeliveryTheme.colors.brand,
        unfocusedLabelColor = DeliveryTheme.colors.secondary.getColorOrError(isError = isError),
        errorLabelColor = DeliveryTheme.colors.error,
    )

    @Composable
    private fun Color.getColorOrError(isError: Boolean) = if (isError) {
        DeliveryTheme.colors.error
    } else {
        this
    }
}

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    label: String? = null,
    isReadOnly: Boolean = false,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    hasBorder: Boolean = true,
    textStyle: TextStyle = DeliveryTheme.typography.body2,
    labelTextStyle: TextStyle = DeliveryTheme.typography.body0,
    shape: Shape = RoundedCornerShape(4.dp),
    textFormat: TextFormat = TextFormat.Text,
    colors: TextFieldColors = InputTextFieldDefaults.textFieldColors(isError = isError),
) {
    var cursorPosition by remember { mutableStateOf(0) }
    var textFieldsModifier = modifier.fillMaxWidth()
    if (hasBorder) {
        textFieldsModifier = textFieldsModifier.border(
            width = 0.5.dp,
            color = if (isError) {
                DeliveryTheme.colors.error
            } else {
                DeliveryTheme.colors.secondary
            },
            shape = shape,
        )
    }
    Column {
        TextField(
            modifier = textFieldsModifier,
            value = TextFieldValue(
                text = value,
                selection = TextRange(cursorPosition),
            ),
            onValueChange = { textFieldValue ->
                val newTextFieldValue = textFormat.filter?.filter(textFieldValue) ?: textFieldValue
                cursorPosition = newTextFieldValue.selection.start
                val text = newTextFieldValue.text
                if (text.length <= textFormat.maxLength) {
                    onValueChange(text)
                }
            },
            maxLines = 1,
            singleLine = true,
            readOnly = isReadOnly,
            shape = DeliveryTheme.shapes.large,
            isError = isError,
            enabled = isEnabled,
            label = label?.let {
                {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = it,
                        style = labelTextStyle,
                    )
                }
            },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            colors = colors,
            visualTransformation = textFormat.visualTransformation,
            keyboardOptions = KeyboardOptions(keyboardType = textFormat.keyboardType),
            textStyle = if (isError) {
                textStyle.copy(color = DeliveryTheme.colors.error)
            } else {
                textStyle
            },
        )
        if (isError) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.input_field_error),
                style = DeliveryTheme.typography.body0,
                color = DeliveryTheme.colors.error,
            )
        }
    }
}
