package com.catnip.egroceries.data.local.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.local.database.entity.ProductEntity

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class CartProductRelation(
    @Embedded
    val cart: CartEntity,
    @Relation(parentColumn = "product_id", entityColumn = "id")
    val product: ProductEntity
)