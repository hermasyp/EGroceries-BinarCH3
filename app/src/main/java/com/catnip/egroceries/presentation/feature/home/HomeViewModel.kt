package com.catnip.egroceries.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.feature.home.adapter.HomeAdapter
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

class HomeViewModel(private val repo: ProductRepository) : ViewModel() {

    val homeData: LiveData<List<HomeSection>>
        get() = repo.getCategories().combine(repo.getProducts()) { f1, f2 -> Pair(f1, f2) }
            .map { (categories, products) ->
                mapToHomeData(categories, products)
            }.asLiveData(Dispatchers.IO)

    private fun mapToHomeData(
        categoryResult: ResultWrapper<List<Category>>,
        productResult: ResultWrapper<List<Product>>
    ): List<HomeSection> =
        listOf(
            HomeSection.HeaderSection,
            HomeSection.BannerSection,
            HomeSection.CategoriesSection(categoryResult),
            HomeSection.ProductsSection(productResult),
        )
}