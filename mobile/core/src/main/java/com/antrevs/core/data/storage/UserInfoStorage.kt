package com.antrevs.core.data.storage

import android.content.Context
import javax.inject.Inject

private const val PREFS_NAME = "USER_INFO"
private const val SESSION_KEY = "SESSION"

class UserInfoStorage @Inject constructor(
    context: Context,
) : BaseStorage(context, PREFS_NAME) {

    fun getSession(): String? = prefs.getString(SESSION_KEY, null)

    fun setSession(session: String) = prefs.edit().putString(SESSION_KEY, session).commit()

    fun reset() {
        prefs.edit().remove(SESSION_KEY).apply()
    }
}