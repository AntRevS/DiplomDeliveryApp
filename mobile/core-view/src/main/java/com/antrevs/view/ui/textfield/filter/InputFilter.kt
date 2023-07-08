package com.antrevs.view.ui.textfield.filter

import androidx.compose.ui.text.input.TextFieldValue

interface InputFilter {

    fun filter(value: TextFieldValue): TextFieldValue
}
