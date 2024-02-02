package com.antrevs.main.common.api

import com.antrevs.core.network.NetworkProvider
import com.antrevs.model.products.GetProductsResponseModel
import dagger.Module
import dagger.Provides
import retrofit2.http.GET
import retrofit2.http.Query

private const val GET_PRODUCTS_URL = "/private/products/all"

interface ProductsApi {

    @GET(GET_PRODUCTS_URL)
    suspend fun getAllProducts(
        @Query("categoryId") categoryId: Long?
    ): GetProductsResponseModel
}

@Module
class ProductsApiModule {

    @Provides
    fun provideApi(
        networkProvider: NetworkProvider,
    ) = networkProvider.providerService(ProductsApi::class)
}
