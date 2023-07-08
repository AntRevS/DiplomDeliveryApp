package com.antrevs.view.ui.textfield

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.antrevs.view.ui.textfield.filter.InputFilter
import com.antrevs.view.ui.textfield.filter.PhoneNumberFilter
import com.antrevs.view.ui.textfield.mask.MaskVisualTransformation

private const val PHONE_NUMBER_MASK = "## ### ###-##-##"

sealed class TextFormat(
    val visualTransformation: VisualTransformation,
    val maxLength: Int,
    val keyboardType: KeyboardType,
    val filter: InputFilter? = null,
) {

    object PhoneNumber : TextFormat(
        visualTransformation = MaskVisualTransformation(PHONE_NUMBER_MASK),
        maxLength = 12,
        keyboardType = KeyboardType.Phone,
        filter = PhoneNumberFilter(),
    )

    object Password : TextFormat(
        visualTransformation = PasswordVisualTransformation(),
        maxLength = 16,
        keyboardType = KeyboardType.Password,
    )

    object Text : TextFormat(
        visualTransformation = VisualTransformation.None,
        maxLength = 16,
        keyboardType = KeyboardType.Text,
    )
}
