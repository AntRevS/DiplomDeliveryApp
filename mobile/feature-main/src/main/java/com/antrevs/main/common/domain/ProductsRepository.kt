package com.antrevs.main.common.domain

import com.antrevs.main.common.domain.entity.ProductsResponse

interface ProductsRepository {

    suspend fun getProducts(categoryId: Long?): ProductsResponse
}
