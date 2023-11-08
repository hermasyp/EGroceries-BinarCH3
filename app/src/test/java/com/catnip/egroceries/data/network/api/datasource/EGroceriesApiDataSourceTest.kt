package com.catnip.egroceries.data.network.api.datasource

import com.catnip.egroceries.data.network.api.model.category.CategoriesResponse
import com.catnip.egroceries.data.network.api.model.order.OrderRequest
import com.catnip.egroceries.data.network.api.model.order.OrderResponse
import com.catnip.egroceries.data.network.api.model.product.ProductsResponse
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class EGroceriesApiDataSourceTest {

    @MockK(relaxed = true)
    lateinit var service: EGroceriesApiService

    private lateinit var dataSource: EGroceriesDataSource

    @Before
    fun setUp() {
        init(this)
        dataSource = EGroceriesApiDataSource(service)
    }

    @Test
    fun getProducts() {
        runTest {
            val mockResponse = mockk<ProductsResponse>(relaxed = true)
            coEvery { service.getProducts(any()) } returns mockResponse
            val result = dataSource.getProducts("category")
            coVerify { service.getProducts(any()) }
            assertEquals(result, mockResponse)
        }
    }

    @Test
    fun getCategories() {
        runTest {
            val mockResponse = mockk<CategoriesResponse>(relaxed = true)
            coEvery { service.getCategories() } returns mockResponse
            val result = dataSource.getCategories()
            coVerify { service.getCategories() }
            assertEquals(result, mockResponse)
        }
    }

    @Test
    fun createOrder() {
        runTest {
            val mockResponse = mockk<OrderResponse>(relaxed = true)
            val mockRequest = mockk<OrderRequest>(relaxed = true)
            coEvery { service.createOrder(any()) } returns mockResponse
            val result = dataSource.createOrder(mockRequest)
            coVerify { service.createOrder(any()) }
            assertEquals(result, mockResponse)
        }
    }
}
