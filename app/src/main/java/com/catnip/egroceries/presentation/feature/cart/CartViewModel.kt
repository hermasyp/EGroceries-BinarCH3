package com.catnip.egroceries.presentation.feature.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.catnip.egroceries.data.repository.CartRepository
import kotlinx.coroutines.Dispatchers

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class CartViewModel(private val repo : CartRepository) : ViewModel() {

    val cartList = repo.getCartList().asLiveData(Dispatchers.IO)
}