package com.catnip.egroceries.data.local.database.mapper

import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.model.Cart

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

fun CartEntity?.toCart() = Cart(
    id = this?.id ?: 0,
    productId = this?.productId ?: 0,
    itemQuantity = this?.itemQuantity ?: 0,
    itemNotes = this?.itemNotes.orEmpty(),
    productPrice = this?.productPrice ?: 0.0,
    productName = this?.productName.orEmpty(),
    productImgUrl = this?.productImgUrl.orEmpty()
)

fun Cart?.toCartEntity() = CartEntity(
    id = this?.id,
    productId = this?.productId ?: 0,
    itemQuantity = this?.itemQuantity ?: 0,
    itemNotes = this?.itemNotes.orEmpty(),
    productPrice = this?.productPrice ?: 0.0,
    productName = this?.productName.orEmpty(),
    productImgUrl = this?.productImgUrl.orEmpty()
)

fun List<CartEntity?>.toCartList() = this.map { it.toCart() }
