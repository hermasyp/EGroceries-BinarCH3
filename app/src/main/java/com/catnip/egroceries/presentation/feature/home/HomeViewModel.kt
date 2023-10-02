package com.catnip.egroceries.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.utils.ResultWrapper
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

class HomeViewModel(private val repo: ProductRepository) : ViewModel() {

    private val _homeData = MutableLiveData<List<HomeSection>>()
    val homeData: LiveData<List<HomeSection>>
        get() = _homeData


    fun fetchHomeData() {
        viewModelScope.launch {
            repo.getProducts().map {
                mapToHomeData(it)
            }.collect{
                _homeData.postValue(it)
            }
        }
    }

    private fun mapToHomeData(productResult : ResultWrapper<List<Product>>): List<HomeSection> = listOf(
        HomeSection.HeaderSection,
        HomeSection.BannerSection,
        HomeSection.CategoriesSection(repo.getCategories()),
        HomeSection.ProductsSection(productResult),
    )
}