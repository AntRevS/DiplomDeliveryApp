package com.antrevs.autorization.features.auth.di

import com.antrevs.autorization.common.api.AuthApiModule
import com.antrevs.autorization.common.di.AuthRepoModule
import com.antrevs.autorization.features.auth.presentation.AuthScreenViewModel
import com.antrevs.core.Application
import com.antrevs.core.di.network.NetworkComponentApi
import com.antrevs.core.di.storage.StorageComponentApi
import dagger.BindsInstance
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
interface AuthScreenComponent {

    val viewModel: AuthScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            networkComponentApi: NetworkComponentApi,
            storageComponentApi: StorageComponentApi,
            @BindsInstance isAuth: Boolean,
        ): AuthScreenComponent
    }

    companion object {

        fun init(
            app: Application,
            isAuth: Boolean,
        ) = DaggerAuthScreenComponent
            .factory()
            .create(
                networkComponentApi = app.networkComponent,
                storageComponentApi = app.storageComponent,
                isAuth = isAuth,
            )
    }
}
