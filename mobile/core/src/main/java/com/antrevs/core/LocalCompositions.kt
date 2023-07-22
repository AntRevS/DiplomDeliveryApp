package com.antrevs.core

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import com.antrevs.core.presentation.DialogHolder

val LocalNavController = staticCompositionLocalOf<NavHostController> { error("Not provided") }

val LocalDialogHolder = staticCompositionLocalOf<DialogHolder> { error("Not provided") }
