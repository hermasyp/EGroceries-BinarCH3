package com.catnip.egroceries.presentation.feature.home2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.utils.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Home2ViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _categories = MutableLiveData<ResultWrapper<List<Category>>>()
    val categories: LiveData<ResultWrapper<List<Category>>>
        get() = _categories

    private val _products = MutableLiveData<ResultWrapper<List<Product>>>()
    val products: LiveData<ResultWrapper<List<Product>>>
        get() = _products

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategories().collect {
                _categories.postValue(it)
            }
        }
    }

    fun getProducts(category: String? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts(if (category == "all") null else category).collect {
                _products.postValue(it)
            }
        }
    }
}
