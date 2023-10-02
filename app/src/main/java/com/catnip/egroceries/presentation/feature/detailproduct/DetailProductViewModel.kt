package com.catnip.egroceries.presentation.feature.detailproduct

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catnip.egroceries.model.Product

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class DetailProductViewModel(private val extras: Bundle?) : ViewModel() {

    val product = extras?.getParcelable<Product>(com.catnip.egroceries.presentation.feature.detailproduct.DetailProductActivity.EXTRA_PRODUCT)

    val priceLiveData = MutableLiveData<Double>().apply {
        postValue(0.0)
    }
    val productCountLiveData = MutableLiveData<Int>().apply {
        postValue(0)
    }

    fun add() {
        val count = (productCountLiveData.value ?: 0) + 1
        productCountLiveData.postValue(count)
        priceLiveData.postValue(product?.price?.times(count) ?: 0.0)
    }

    fun minus() {
        if((productCountLiveData.value ?: 0) > 0){
            val count = (productCountLiveData.value ?: 0) -1
            productCountLiveData.postValue(count)
            priceLiveData.postValue(product?.price?.times(count) ?: 0.0)
        }
    }


}