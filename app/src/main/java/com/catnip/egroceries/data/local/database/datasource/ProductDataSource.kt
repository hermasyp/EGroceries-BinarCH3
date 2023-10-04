package com.catnip.egroceries.data.local.database.datasource

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.catnip.egroceries.data.local.database.dao.ProductDao
import com.catnip.egroceries.data.local.database.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface ProductDataSource {
    fun getAllProducts(): Flow<List<ProductEntity>>
    fun getProductById(id: Int): Flow<ProductEntity>
    suspend fun insertProducts(product: List<ProductEntity>)
    suspend fun deleteProduct(product: ProductEntity): Int
    suspend fun updateProduct(product: ProductEntity): Int

}

class ProductDatabaseDataSource(private val dao : ProductDao) : ProductDataSource {
    override fun getAllProducts(): Flow<List<ProductEntity>> {
        return dao.getAllProducts()
    }

    override fun getProductById(id: Int): Flow<ProductEntity> {
        return dao.getProductById(id)
    }

    override suspend fun insertProducts(product: List<ProductEntity>) {
        return dao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: ProductEntity): Int {
        return dao.deleteProduct(product)
    }

    override suspend fun updateProduct(product: ProductEntity): Int {
        return dao.updateProduct(product)
    }

}