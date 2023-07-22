package com.antrevs.core.data.storage

import android.content.Context
import android.content.SharedPreferences

abstract class BaseStorage(
    context: Context,
    name: String,
) {

    protected val prefs: SharedPreferences =
        context.getSharedPreferences(name, Context.MODE_PRIVATE)
}
