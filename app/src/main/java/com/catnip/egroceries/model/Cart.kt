package com.catnip.egroceries.model

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class Cart(
    var id: Int? = 0,
    var productId : Int = 0,
    var itemQuantity: Int = 0,
    var itemNotes: String? = null,
)
