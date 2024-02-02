package com.antrevs.main.common.data.mapper

import com.antrevs.main.common.domain.entity.Category
import com.antrevs.main.common.domain.entity.Product
import com.antrevs.main.common.domain.entity.ProductsResponse
import com.antrevs.model.entity.CategoryModel
import com.antrevs.model.entity.ProductModel
import com.antrevs.model.products.GetProductsResponseModel

fun GetProductsResponseModel.toProductsResponse() = ProductsResponse(
    categories = categories.map { it.toCategory() },
)

fun ProductModel.toProduct() = Product(
    id = id,
    name = name,
    price = price,
    image = imageUrl,
)

fun CategoryModel.toCategory() = Category(
    id = id,
    name = name,
    products = products.map { it.toProduct() }
)