package com.antrevs.main.common.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.math.BigDecimal

data class Product(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: BigDecimal,
    @SerializedName("image")
    val image: String? = null,
) : Serializable
