package com.catnip.egroceries.data.repository

import com.catnip.egroceries.data.dummy.DummyCategoryDataSource
import com.catnip.egroceries.data.dummy.DummyProductDataSourceImpl
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.datasource.ProductDataSource
import com.catnip.egroceries.data.local.database.mapper.toProductList
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
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
interface ProductRepository {
    fun getCategories(): List<Category>
    fun getProducts(): Flow<ResultWrapper<List<Product>>>
}

class ProductRepositoryImpl(
    private val productDataSource: ProductDataSource,
    private val dummyCategoryDataSource: DummyCategoryDataSource
) : ProductRepository {

    override fun getCategories(): List<Category> {
        return dummyCategoryDataSource.getProductCategory()
    }

    override fun getProducts(): Flow<ResultWrapper<List<Product>>> {
        return productDataSource.getAllProducts().map { proceed { it.toProductList() } }.onStart {
            emit(ResultWrapper.Loading())
            delay(2000)
        }
    }
}