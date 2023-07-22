package com.antrevs.delivery.di.storage

import android.content.Context
import com.antrevs.core.di.storage.StorageComponentApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface StorageComponent : StorageComponentApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context,
        ): StorageComponent
    }
}
