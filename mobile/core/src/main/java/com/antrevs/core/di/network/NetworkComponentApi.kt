package com.antrevs.core.di.network

import com.antrevs.core.network.NetworkProvider

interface NetworkComponentApi {

    fun getNetworkProvider(): NetworkProvider
}
