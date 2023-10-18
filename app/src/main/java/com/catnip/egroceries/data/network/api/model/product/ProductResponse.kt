package com.catnip.egroceries.data.network.api.model.product


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.catnip.egroceries.model.Product

@Keep
data class ProductResponse(
    @SerializedName("desc")
    val desc: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("product_img_url")
    val productImgUrl: String?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("supplier_name")
    val supplierName: String?,
    @SerializedName("weight_in_kg")
    val weightInKg: Double?
)

fun ProductResponse.toProduct() = Product(
    id = this.id,
    name = this.name.orEmpty(),
    price = this.price ?: 0.0,
    weightInKg = this.weightInKg ?: 0.0,
    supplierName = this.supplierName.orEmpty(),
    rating = this.rating ?: 0.0,
    desc = this.desc.orEmpty(),
    productImgUrl = this.productImgUrl.orEmpty()
)

fun Collection<ProductResponse>.toProductList() = this.map { it.toProduct() }