package com.catnip.egroceries.data.local.database.mapper

import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.local.database.relation.CartProductRelation
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
// Entity > View Object
fun CartEntity?.toCart() = Cart(
    id = this?.id ?: 0,
    productId = this?.productId ?: 0,
    itemQuantity = this?.itemQuantity ?: 0,
    itemNotes = this?.itemNotes.orEmpty()
)
// View Object > Entity
fun Cart?.toCartEntity() = CartEntity(
    id = this?.id,
    productId = this?.productId ?: 0,
    itemQuantity = this?.itemQuantity ?: 0,
    itemNotes = this?.itemNotes.orEmpty()
)
// list of entity > list of view object
fun List<CartEntity?>.toCartList() = this.map { it.toCart() }

// Entity > View Object
fun CartProductRelation.toCartProduct() = CartProduct(
    cart = this.cart.toCart(),
    product = this.product.toProduct()
)
// list of entity > list of view object
fun List<CartProductRelation>.toCartProductList() = this.map { it.toCartProduct() }