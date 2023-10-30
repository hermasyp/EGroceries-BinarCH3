package com.catnip.egroceries.data.network.api.model.product

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductsResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("data")
    val data: List<ProductItemResponse>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
)
