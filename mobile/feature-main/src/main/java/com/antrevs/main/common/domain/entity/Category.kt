package com.antrevs.main.common.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("products")
    val products: List<Product>,
): Serializable
