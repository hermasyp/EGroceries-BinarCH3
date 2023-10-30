package com.catnip.egroceries.model

import java.util.UUID

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class Category(
    val id: String = UUID.randomUUID().toString(),
    val categoryImgUrl: String,
    val slug: String?,
    val name: String
)
