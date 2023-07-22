package com.antrevs.delivery

import androidx.multidex.MultiDexApplication
import com.antrevs.core.Application
import com.antrevs.core.di.network.NetworkComponentApi
import com.antrevs.core.di.storage.StorageComponentApi
import com.antrevs.core.di.ui.UiComponentApi
import com.antrevs.delivery.di.network.DaggerNetworkComponent
import com.antrevs.delivery.di.storage.DaggerStorageComponent
import com.antrevs.delivery.di.ui.DaggerUiComponent

class DeliveryApplication : MultiDexApplication(), Application {

    override val networkComponent: NetworkComponentApi by lazy {
        DaggerNetworkComponent
            .builder()
            .storageComponentApi(storageComponent)
            .build()
    }

    override val storageComponent: StorageComponentApi by lazy {
        DaggerStorageComponent
            .factory()
            .create(this)
    }

    override val uiComponent: UiComponentApi by lazy {
        DaggerUiComponent.builder().build()
    }
}
