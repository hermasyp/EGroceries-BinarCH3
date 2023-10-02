package com.catnip.egroceries.data.local.database.datasource

import com.catnip.egroceries.data.local.database.dao.CartDao
import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.local.database.relation.CartProductRelation
import kotlinx.coroutines.flow.Flow

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface CartDataSource {
    fun getAllCarts(): Flow<List<CartProductRelation>>
    fun getCartById(cartId: Int): Flow<CartProductRelation>
    suspend fun insertCart(cart: CartEntity)
    suspend fun insertCarts(carts: List<CartEntity>)
    suspend fun deleteCart(cart: CartEntity): Int
    suspend fun updateCart(cart: CartEntity): Int
}

class CartDatabaseDataSource(
    private val dao : CartDao
) : CartDataSource{
    override fun getAllCarts(): Flow<List<CartProductRelation>> {
        return dao.getAllCarts()
    }

    override fun getCartById(cartId: Int): Flow<CartProductRelation> {
        return dao.getCartById(cartId)
    }

    override suspend fun insertCart(cart: CartEntity) {
        dao.insertCart(cart)
    }

    override suspend fun insertCarts(carts: List<CartEntity>) {
        dao.insertCarts(carts)
    }

    override suspend fun deleteCart(cart: CartEntity): Int {
        return dao.deleteCart(cart)
    }

    override suspend fun updateCart(cart: CartEntity): Int {
        return dao.updateCart(cart)
    }
}
