package com.antrevs.core

import com.antrevs.core.di.network.NetworkComponentApi
import com.antrevs.core.di.storage.StorageComponentApi
import com.antrevs.core.di.ui.UiComponentApi

interface Application {

    val networkComponent: NetworkComponentApi

    val storageComponent: StorageComponentApi

    val uiComponent: UiComponentApi
}
