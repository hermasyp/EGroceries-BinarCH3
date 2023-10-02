package com.catnip.egroceries.data.repository

import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.mapper.toCartProductList
import com.catnip.egroceries.data.local.database.mapper.toProductList
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct
import com.catnip.egroceries.utils.ResultWrapper
import com.catnip.egroceries.utils.proceed
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface CartRepository {
    fun getCartList(): Flow<ResultWrapper<List<CartProduct>>>
}

class CartRepositoryImpl(
    private val dataSource: CartDataSource
) : CartRepository {
    override fun getCartList(): Flow<ResultWrapper<List<CartProduct>>> {
        return dataSource.getAllCarts().map { proceed { it.toCartProductList() } }.onStart {
            emit(ResultWrapper.Loading())
            delay(2000)
        }
    }
}