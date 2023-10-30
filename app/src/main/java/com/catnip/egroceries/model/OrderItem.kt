package com.catnip.egroceries.model

import com.catnip.egroceries.data.network.api.model.order.OrderItemRequest

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class OrderItem(
    val notes: String,
    val productId: Int,
    val qty: Int
)

fun OrderItem.toOrderItemRequest() = OrderItemRequest(notes, productId, qty)
