package com.antrevs.autorization.common.domain

interface AuthRepository {

    suspend fun resetSession()

    suspend fun auth(
        phoneNumber: String,
        password: String,
    )

    suspend fun register(
        phoneNumber: String,
        password: String,
    )
}
