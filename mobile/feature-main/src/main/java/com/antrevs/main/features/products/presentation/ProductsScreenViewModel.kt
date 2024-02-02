package com.antrevs.main.features.products.presentation

import com.antrevs.core.presentation.BaseViewModel
import com.antrevs.main.common.domain.ProductsRepository
import com.antrevs.main.features.products.presentation.mapper.toProductCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class ProductsScreenViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,
) : BaseViewModel() {

    private val _state = MutableStateFlow(ProductsScreenState())
    val state = _state.asStateFlow()

    fun onCreate() {
        launch {
            val list = productsRepository.getProducts(categoryId = null)
            _state.update { state ->
                state.copy(products = list.categories.map { it.toProductCategory() })
            }
        }
    }
}
