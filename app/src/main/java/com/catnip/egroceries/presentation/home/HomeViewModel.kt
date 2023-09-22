package com.catnip.egroceries.presentation.home

import androidx.lifecycle.ViewModel
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.home.adapter.model.HomeSection

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

class HomeViewModel(private val repo: ProductRepository) : ViewModel() {
    fun getHomeSectionData(): List<HomeSection> = listOf(
        HomeSection.HeaderSection,
        HomeSection.BannerSection,
        HomeSection.CategoriesSection(repo.getCategories()),
        HomeSection.ProductsSection(repo.getProducts()),
    )
}