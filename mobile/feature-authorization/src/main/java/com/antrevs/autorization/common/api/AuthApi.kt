package com.antrevs.autorization.common.api

import com.antrevs.autorization.common.data.entity.AuthRequest
import com.antrevs.core.network.NetworkProvider
import com.antrevs.model.auth.AuthResponseModel
import dagger.Module
import dagger.Provides
import retrofit2.http.Body
import retrofit2.http.POST

private const val REGISTER_URL = "/public/register"
private const val AUTH_URL = "/public/auth"

interface AuthApi {

    @POST(REGISTER_URL)
    suspend fun register(
        @Body request: AuthRequest,
    ): AuthResponseModel

    @POST(AUTH_URL)
    suspend fun auth(
        @Body request: AuthRequest,
    ): AuthResponseModel
}

@Module
class AuthApiModule {

    @Provides
    fun provideApi(
        networkProvider: NetworkProvider,
    ) = networkProvider.providerService(AuthApi::class)
}
