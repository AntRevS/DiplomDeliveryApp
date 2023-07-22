package com.antrevs.delivery.di.network

import com.antrevs.core.di.network.NetworkComponentApi
import com.antrevs.core.di.storage.StorageComponentApi
import com.antrevs.delivery.di.storage.StorageComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        StorageComponentApi::class
    ],
    modules = [
        NetworkModule::class
    ]
)
interface NetworkComponent : NetworkComponentApi
