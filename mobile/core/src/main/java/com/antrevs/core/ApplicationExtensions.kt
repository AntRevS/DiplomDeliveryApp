package com.antrevs.core

import android.content.Context
import androidx.core.app.ComponentActivity

fun Context.getActivity(): ComponentActivity = if (this is ComponentActivity) {
    this
} else {
    throw NoSuchElementException("Context does not provide activity")
}

fun Context.getApp(): Application = getActivity().application as Application
