package com.catnip.egroceries.data.network.api.model.category

import androidx.annotation.Keep
import com.catnip.egroceries.model.Category
import com.google.gson.annotations.SerializedName

@Keep
data class CategoryResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("img_url")
    val imgUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)

fun CategoryResponse.toCategory() = Category(
    id = this.id.orEmpty(),
    categoryImgUrl = this.imgUrl.orEmpty(),
    name = this.name.orEmpty(),
    slug = this.slug.orEmpty()
)

fun Collection<CategoryResponse>.toCategoryList() = this.map {
    it.toCategory()
}
