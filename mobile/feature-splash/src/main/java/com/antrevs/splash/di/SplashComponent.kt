package com.antrevs.splash.di

import com.antrevs.core.Application
import com.antrevs.core.di.storage.StorageComponentApi
import com.antrevs.splash.presentation.SplashViewModel
import dagger.Component

@Component(
    dependencies = [
        StorageComponentApi::class,
    ],
    modules = [
        SplashModule::class,
    ]
)
interface SplashComponent {

    val viewModel: SplashViewModel

    @Component.Factory
    interface Factory {

        fun create(
            storageComponentApi: StorageComponentApi,
        ): SplashComponent
    }

    companion object {

        fun init(app: Application) = DaggerSplashComponent
            .factory()
            .create(app.storageComponent)
    }
}