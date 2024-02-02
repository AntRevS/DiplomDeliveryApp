package com.antrevs.profile.features.settings.presentation

sealed interface EditDialogState {

    object PhoneNumber: EditDialogState

    object Name: EditDialogState

    object Mail: EditDialogState
}
