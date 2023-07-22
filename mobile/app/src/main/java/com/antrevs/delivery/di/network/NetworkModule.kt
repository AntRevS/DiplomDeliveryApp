package com.antrevs.delivery.di.network

import com.antrevs.core.data.storage.UserInfoStorage
import com.antrevs.core.network.NetworkProvider
import com.antrevs.core.network.NetworkProviderImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()

    @Singleton
    @Provides
    fun provideNetworkProvider(
        userInfoStorage: UserInfoStorage,
        gson: Gson,
    ): NetworkProvider = NetworkProviderImpl(
        userInfoStorage = userInfoStorage,
        gson = gson,
    )
}
