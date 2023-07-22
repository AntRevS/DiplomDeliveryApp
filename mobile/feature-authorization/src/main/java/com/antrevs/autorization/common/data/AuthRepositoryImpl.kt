package com.antrevs.autorization.common.data

import com.antrevs.autorization.common.api.AuthApi
import com.antrevs.autorization.common.data.entity.AuthRequest
import com.antrevs.autorization.common.domain.AuthRepository
import com.antrevs.core.data.storage.UserInfoStorage
import com.antrevs.core.data.utils.apiRequest
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val userInfoStorage: UserInfoStorage,
) : AuthRepository {

    override suspend fun resetSession() = userInfoStorage.reset()

    override suspend fun auth(
        phoneNumber: String,
        password: String,
    ) {
        apiRequest {
            authApi.auth(
                request = AuthRequest(
                    phoneNumber = phoneNumber,
                    password = password,
                ),
            )
        }.also {
            userInfoStorage.setSession(it.sessionId)
        }
    }

    override suspend fun register(
        phoneNumber: String,
        password: String,
    ) {
        apiRequest {
            authApi.register(
                request = AuthRequest(
                    phoneNumber = phoneNumber,
                    password = password,
                ),
            )
        }
    }
}
