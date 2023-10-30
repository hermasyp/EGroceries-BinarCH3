package com.catnip.egroceries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
@Parcelize
data class Product(
    val id: Int? = null,
    val name: String,
    val price: Double,
    val weightInKg: Double,
    val supplierName: String,
    val rating: Double,
    val desc: String,
    val productImgUrl: String
) : Parcelable
