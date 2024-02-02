package com.antrevs.main.features.products.presentation.entity

data class ProductCategory(
    val id: Long,
    val name: String,
    val products: List<ProductItem>,
)
