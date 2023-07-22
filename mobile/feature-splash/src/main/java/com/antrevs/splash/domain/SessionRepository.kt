package com.antrevs.splash.domain

interface SessionRepository {

    suspend fun isSessionExist(): Boolean
}
