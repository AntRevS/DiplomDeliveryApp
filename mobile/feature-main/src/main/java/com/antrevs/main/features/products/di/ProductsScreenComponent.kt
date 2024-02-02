package com.antrevs.main.features.products.di

import com.antrevs.core.Application
import com.antrevs.core.di.network.NetworkComponentApi
import com.antrevs.main.common.api.ProductsApiModule
import com.antrevs.main.common.di.MainModule
import com.antrevs.main.features.products.presentation.ProductsScreenViewModel
import dagger.Component

@Component(
    dependencies = [
        NetworkComponentApi::class
    ],
    modules = [
        MainModule::class,
        ProductsApiModule::class
    ]
)
interface ProductsScreenComponent {

    val viewModel: ProductsScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            networkComponentApi: NetworkComponentApi,
        ): ProductsScreenComponent
    }

    companion object {
        fun init(app: Application) = DaggerProductsScreenComponent
            .factory()
            .create(app.networkComponent)
    }
}
