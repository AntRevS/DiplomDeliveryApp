package com.antrevs.main.common.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsResponse(
    @SerializedName("categories")
    val categories: List<Category>,
) : Serializable
