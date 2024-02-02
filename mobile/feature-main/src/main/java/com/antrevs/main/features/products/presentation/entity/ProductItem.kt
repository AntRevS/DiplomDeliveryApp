package com.antrevs.main.features.products.presentation.entity

import com.antrevs.view.ui.productitem.ProductItemState

data class ProductItem(
    val id: Long,
    val state: ProductItemState,
)
