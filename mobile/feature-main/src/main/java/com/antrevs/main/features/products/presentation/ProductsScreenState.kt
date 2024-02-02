package com.antrevs.main.features.products.presentation

import com.antrevs.main.features.products.presentation.entity.ProductCategory

data class ProductsScreenState(
    val products: List<ProductCategory> = emptyList(),
)
