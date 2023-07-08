package com.antrevs.view.ui.textfield.filter

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

private const val PLUS_SYMBOL = '+'
private const val RU_CODE = "7"

class PhoneNumberFilter: InputFilter {

    override fun filter(value: TextFieldValue): TextFieldValue {
        var newText = value.text.filter { it.isDigit() || it == PLUS_SYMBOL }
        val prefix = "$PLUS_SYMBOL$RU_CODE"
        if (newText.isNotEmpty()) {
            if (!newText.startsWith(prefix = prefix)) {
                if (newText == PLUS_SYMBOL.toString()) {
                    newText = newText.filter { it != PLUS_SYMBOL }
                    newText = "$prefix $newText"
                } else {
                    newText = "$prefix$newText"
                }
            }
            if (newText == prefix) {
                newText = ""
            }
        }
        return TextFieldValue(
            text = newText,
            selection = TextRange(newText.length),
        )
    }
}
