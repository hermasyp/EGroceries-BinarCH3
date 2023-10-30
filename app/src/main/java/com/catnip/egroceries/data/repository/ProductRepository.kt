package com.catnip.egroceries.data.repository

import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.data.network.api.model.category.toCategoryList
import com.catnip.egroceries.data.network.api.model.product.toProductList
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.utils.ResultWrapper
import com.catnip.egroceries.utils.proceedFlow
import kotlinx.coroutines.flow.Flow

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface ProductRepository {
    fun getCategories(): Flow<ResultWrapper<List<Category>>>
    fun getProducts(category: String? = null): Flow<ResultWrapper<List<Product>>>
}

class ProductRepositoryImpl(
    private val apiDataSource: EGroceriesDataSource
) : ProductRepository {

    override fun getCategories(): Flow<ResultWrapper<List<Category>>> {
        return proceedFlow {
            apiDataSource.getCategories().data?.toCategoryList() ?: emptyList()
        }
    }

    override fun getProducts(category: String?): Flow<ResultWrapper<List<Product>>> {
        return proceedFlow {
            apiDataSource.getProducts(category).data?.toProductList() ?: emptyList()
        }
    }
}
