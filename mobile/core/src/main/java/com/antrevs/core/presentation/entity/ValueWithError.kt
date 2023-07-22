package com.antrevs.core.presentation.entity

data class ValueWithErrorState(
    val value: String,
    val isError: Boolean = false,
)
