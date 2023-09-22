package com.catnip.egroceries.presentation.home.adapter.model

import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
sealed class HomeSection {
    data object HeaderSection : HomeSection()
    data object BannerSection : HomeSection()
    data class CategoriesSection(val data : List<Category>) : HomeSection()
    data class ProductsSection(val data : List<Product>) : HomeSection()
}
