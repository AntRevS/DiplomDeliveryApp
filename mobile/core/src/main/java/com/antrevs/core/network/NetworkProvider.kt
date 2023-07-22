package com.antrevs.core.network

import kotlin.reflect.KClass

interface NetworkProvider {

    fun <T: Any> providerService(serviceClass: KClass<T>): T
}
