package com.antrevs.main.common.data

import com.antrevs.core.data.utils.apiRequest
import com.antrevs.main.common.api.ProductsApi
import com.antrevs.main.common.data.mapper.toProductsResponse
import com.antrevs.main.common.domain.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi,
) : ProductsRepository {

    override suspend fun getProducts(categoryId: Long?) = apiRequest {
        productsApi.getAllProducts(categoryId)
    }.toProductsResponse()
}
