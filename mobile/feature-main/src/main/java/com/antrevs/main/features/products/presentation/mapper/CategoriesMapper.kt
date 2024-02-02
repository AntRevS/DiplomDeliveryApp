package com.antrevs.main.features.products.presentation.mapper

import com.antrevs.core.domain.Currency
import com.antrevs.main.common.domain.entity.Category
import com.antrevs.main.features.products.presentation.entity.ProductCategory
import com.antrevs.main.features.products.presentation.entity.ProductItem
import com.antrevs.view.ui.productitem.ProductItemState

fun Category.toProductCategory() = ProductCategory(
    id = id,
    name = name,
    products = products.map { product ->
        ProductItem(
            id = id,
            state = ProductItemState(
                title = product.name,
                imageUrl = product.image.orEmpty(),
                badgeText = "${product.price} ${Currency.RUB}",
                productsCount = 0,
            ),
        )
    },
)