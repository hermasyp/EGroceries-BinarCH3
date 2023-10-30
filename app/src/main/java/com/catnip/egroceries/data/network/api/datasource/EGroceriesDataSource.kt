package com.catnip.egroceries.data.network.api.datasource

import com.catnip.egroceries.data.network.api.model.category.CategoriesResponse
import com.catnip.egroceries.data.network.api.model.order.OrderRequest
import com.catnip.egroceries.data.network.api.model.order.OrderResponse
import com.catnip.egroceries.data.network.api.model.product.ProductsResponse
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface EGroceriesDataSource {
    suspend fun getProducts(category: String? = null): ProductsResponse
    suspend fun getCategories(): CategoriesResponse
    suspend fun createOrder(orderRequest: OrderRequest): OrderResponse
}

class EGroceriesApiDataSource(private val service: EGroceriesApiService) : EGroceriesDataSource {
    override suspend fun getProducts(category: String?): ProductsResponse {
        return service.getProducts(category)
    }

    override suspend fun getCategories(): CategoriesResponse {
        return service.getCategories()
    }

    override suspend fun createOrder(orderRequest: OrderRequest): OrderResponse {
        return service.createOrder(orderRequest)
    }
}
