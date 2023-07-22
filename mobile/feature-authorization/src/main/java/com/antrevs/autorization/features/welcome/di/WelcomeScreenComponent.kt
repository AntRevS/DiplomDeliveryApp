package com.antrevs.autorization.features.welcome.di

import com.antrevs.autorization.common.api.AuthApiModule
import com.antrevs.autorization.common.di.AuthRepoModule
import com.antrevs.autorization.features.welcome.presentation.WelcomeScreenViewModel
import com.antrevs.core.Application
import com.antrevs.core.di.network.NetworkComponentApi
import com.antrevs.core.di.storage.StorageComponentApi
import dagger.Component

@Component(
    dependencies = [
        NetworkComponentApi::class,
        StorageComponentApi::class,
    ],
    modules = [
        AuthRepoModule::class,
        AuthApiModule::class,
    ]
)
interface WelcomeScreenComponent {

    val viewModel: WelcomeScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            networkComponentApi: NetworkComponentApi,
            storageComponentApi: StorageComponentApi,
        ): WelcomeScreenComponent
    }

    companion object {

        fun init(app: Application): WelcomeScreenComponent =
            DaggerWelcomeScreenComponent
                .factory()
                .create(
                    networkComponentApi = app.networkComponent,
                    storageComponentApi = app.storageComponent,
                )
    }
}
