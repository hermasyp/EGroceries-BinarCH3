package com.catnip.egroceries.presentation.feature.home.adapter.model

import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.feature.home.adapter.HomeAdapter
import com.catnip.egroceries.utils.ResultWrapper

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
sealed class HomeSection(val id: Int) {
    data object HeaderSection : HomeSection(HomeAdapter.ITEM_TYPE_HEADER)
    data object BannerSection : HomeSection(HomeAdapter.ITEM_TYPE_BANNER)
    data class CategoriesSection(val data: ResultWrapper<List<Category>>) : HomeSection(HomeAdapter.ITEM_TYPE_CATEGORY_LIST)
    data class ProductsSection(val data: ResultWrapper<List<Product>>) : HomeSection(HomeAdapter.ITEM_TYPE_PRODUCT_LIST)
}
