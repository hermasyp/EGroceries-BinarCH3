package com.catnip.egroceries.presentation.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.catnip.egroceries.R
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.utils.AssetWrapper
import com.catnip.egroceries.utils.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: ProductRepository,
    private val assetWrapper: AssetWrapper
) : ViewModel() {

    private val productsFlow =
        MutableStateFlow<ResultWrapper<List<Product>>>(ResultWrapper.Loading())

    val homeData: LiveData<List<HomeSection>>
        get() = repo.getCategories().combine(productsFlow) { f1, f2 -> Pair(f1, f2) }
            .map { (categories, products) ->
                mapToHomeData(categories, products)
            }.onStart {
                setSelectedCategory(null)
            }.asLiveData(Dispatchers.IO)

    private fun mapToHomeData(
        categoryResult: ResultWrapper<List<Category>>,
        productResult: ResultWrapper<List<Product>>
    ): List<HomeSection> =
        listOf(
            HomeSection.HeaderSection,
            HomeSection.BannerSection,
            HomeSection.CategoriesSection(categoryResult),
            HomeSection.ProductsSection(productResult)
        )

    fun setSelectedCategory(category: String? = null) {
        viewModelScope.launch {
            repo.getProducts(if (category == assetWrapper.getString(R.string.all)) null else category)
                .collect {
                    productsFlow.emit(it)
                }
        }
    }
}
