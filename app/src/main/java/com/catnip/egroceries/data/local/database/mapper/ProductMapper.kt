package com.catnip.egroceries.data.local.database.mapper

import com.catnip.egroceries.data.local.database.entity.ProductEntity
import com.catnip.egroceries.model.Product

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

fun ProductEntity?.toProduct() = Product(
    id = this?.id ?: 0,
    name = this?.name.orEmpty(),
    price = this?.price ?: 0.0,
    weightInKg = this?.weightInKg ?: 0.0,
    supplierName = this?.supplierName.orEmpty(),
    rating = this?.rating ?: 0.0,
    desc = this?.desc.orEmpty(),
    productImgUrl = this?.productImgUrl.orEmpty(),
)

fun Product?.toProductEntity() = ProductEntity(
    id = this?.id,
    name = this?.name.orEmpty(),
    price = this?.price ?: 0.0,
    weightInKg = this?.weightInKg ?: 0.0,
    supplierName = this?.supplierName.orEmpty(),
    rating = this?.rating ?: 0.0,
    desc = this?.desc.orEmpty(),
    productImgUrl = this?.productImgUrl.orEmpty(),
)

fun List<ProductEntity?>.toProductList() = this.map { it.toProduct() }
fun List<Product?>.toProductEntity() = this.map { it.toProductEntity() }
