package com.antrevs.splash.data

import com.antrevs.core.data.storage.UserInfoStorage
import com.antrevs.splash.domain.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val userInfoStorage: UserInfoStorage,
) : SessionRepository {

    override suspend fun isSessionExist() = (userInfoStorage.getSession() != null)
}
