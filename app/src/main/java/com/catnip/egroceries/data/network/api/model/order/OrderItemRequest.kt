package com.catnip.egroceries.data.network.api.model.order

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class OrderItemRequest(
    @SerializedName("notes")
    val notes: String?,
    @SerializedName("product_id")
    val productId: Int?,
    @SerializedName("qty")
    val qty: Int?
)
