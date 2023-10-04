package com.catnip.egroceries.data.repository

import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.local.database.mapper.toCartEntity
import com.catnip.egroceries.data.local.database.mapper.toCartProductList
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.utils.ResultWrapper
import com.catnip.egroceries.utils.proceed
import com.catnip.egroceries.utils.proceedFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import java.lang.IllegalStateException

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface CartRepository {
    fun getUserCartData(): Flow<ResultWrapper<Pair<List<CartProduct>, Double>>>
    suspend fun createCart(product: Product, totalQuantity: Int): Flow<ResultWrapper<Boolean>>
    suspend fun decreaseCart(item: Cart): Flow<ResultWrapper<Boolean>>
    suspend fun increaseCart(item: Cart): Flow<ResultWrapper<Boolean>>
    suspend fun setCartNotes(item: Cart): Flow<ResultWrapper<Boolean>>
    suspend fun deleteCart(item: Cart): Flow<ResultWrapper<Boolean>>
}

class CartRepositoryImpl(
    private val dataSource: CartDataSource
) : CartRepository {

    override fun getUserCartData(): Flow<ResultWrapper<Pair<List<CartProduct>, Double>>> {
        return dataSource.getAllCarts().map {
            proceed {
                val cartList = it.toCartProductList()
                val totalPrice = cartList.sumOf {
                    val quantity = it.cart.itemQuantity
                    val pricePerItem = it.product.price
                    quantity * pricePerItem
                }
                Pair(cartList, totalPrice)
            }
        }.onStart {
            emit(ResultWrapper.Loading())
            delay(2000)
        }
    }
    //gunakan di detail
    override suspend fun createCart(
        product: Product,
        totalQuantity: Int
    ): Flow<ResultWrapper<Boolean>> {
        return product.id?.let { productId ->
            proceedFlow {
                val affectedRow = dataSource.insertCart(
                    CartEntity(productId = productId, itemQuantity = totalQuantity)
                )
                affectedRow > 0
            }
        } ?: flow {
            emit(ResultWrapper.Error(IllegalStateException("Product ID not found")))
        }
    }

    override suspend fun decreaseCart(item: Cart): Flow<ResultWrapper<Boolean>> {
        val modifiedCart = item.copy().apply {
            itemQuantity -= 1
        }
        return if (modifiedCart.itemQuantity <= 0) {
            proceedFlow { dataSource.deleteCart(modifiedCart.toCartEntity()) > 0 }
        } else {
            proceedFlow { dataSource.updateCart(modifiedCart.toCartEntity()) > 0 }
        }
    }

    override suspend fun increaseCart(item: Cart): Flow<ResultWrapper<Boolean>> {
        val modifiedCart = item.copy().apply {
            itemQuantity += 1
        }
        return proceedFlow { dataSource.updateCart(modifiedCart.toCartEntity()) > 0 }
    }

    override suspend fun setCartNotes(item: Cart): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.updateCart(item.toCartEntity()) > 0 }
    }

    override suspend fun deleteCart(item: Cart): Flow<ResultWrapper<Boolean>> {
        return proceedFlow { dataSource.deleteCart(item.toCartEntity()) > 0 }
    }

}