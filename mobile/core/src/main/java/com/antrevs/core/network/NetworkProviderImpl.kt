package com.antrevs.core.network

import com.antrevs.core.data.storage.UserInfoStorage
import com.antrevs.core.network.interceptor.SessionInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import kotlin.reflect.KClass

private const val BASE_URl = "http://10.0.2.2:8080"

class NetworkProviderImpl @Inject constructor(
    private val userInfoStorage: UserInfoStorage,
    private val gson: Gson,
): NetworkProvider {

    override fun <T : Any> providerService(serviceClass: KClass<T>): T =
        provideRetrofit(
            client = provideOkHttpClient(),
            gson = gson,
        ).create(serviceClass.java)

    private fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(SessionInterceptor(userInfoStorage))
            .build()

    private fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson,
    ): Retrofit {
        val gsonConverterFactory = GsonConverterFactory.create(gson)
        return Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(gsonConverterFactory)
            .client(client)
            .build()
    }
}