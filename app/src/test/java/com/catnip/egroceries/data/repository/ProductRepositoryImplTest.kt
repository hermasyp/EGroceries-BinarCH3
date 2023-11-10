package com.catnip.egroceries.data.repository

import app.cash.turbine.test
import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.data.network.api.model.category.CategoriesResponse
import com.catnip.egroceries.data.network.api.model.category.CategoryResponse
import com.catnip.egroceries.data.network.api.model.product.ProductItemResponse
import com.catnip.egroceries.data.network.api.model.product.ProductsResponse
import com.catnip.egroceries.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.lang.IllegalStateException

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class ProductRepositoryImplTest {

    @MockK
    lateinit var remoteDataSource: EGroceriesDataSource

    private lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = ProductRepositoryImpl(remoteDataSource)
    }

    @Test
    fun `get categories, with result loading`() {
        val mockCategoryResponse = mockk<CategoriesResponse>()
        runTest {
            coEvery { remoteDataSource.getCategories() } returns mockCategoryResponse
            repository.getCategories().map {
                delay(100)
                it
            }.test {
                delay(110)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Loading)
                coVerify { remoteDataSource.getCategories() }
            }
        }
    }

    @Test
    fun `get categories, with result success`() {
        val fakeCategoryResponse = CategoryResponse(
            id = "124",
            imgUrl = "url",
            name = "name",
            slug = "slug"
        )
        val fakeCategoriesResponse = CategoriesResponse(
            code = 200,
            status = true,
            message = "Success",
            data = listOf(fakeCategoryResponse)
        )
        runTest {
            coEvery { remoteDataSource.getCategories() } returns fakeCategoriesResponse
            repository.getCategories().map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Success)
                assertEquals(data.payload?.size, 1)
                assertEquals(data.payload?.get(0)?.id, "124")
                coVerify { remoteDataSource.getCategories() }
            }
        }
    }

    @Test
    fun `get categories, with result empty`() {
        val fakeCategoriesResponse = CategoriesResponse(
            code = 200,
            status = true,
            message = "Success but empty",
            data = emptyList()
        )
        runTest {
            coEvery { remoteDataSource.getCategories() } returns fakeCategoriesResponse
            repository.getCategories().map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Empty)
                coVerify { remoteDataSource.getCategories() }
            }
        }
    }

    @Test
    fun `get categories, with result error`() {
        runTest {
            coEvery { remoteDataSource.getCategories() } throws IllegalStateException("Mock error")
            repository.getCategories().map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Error)
                coVerify { remoteDataSource.getCategories() }
            }
        }
    }

    @Test
    fun `get products, with result loading`() {
        val mockProductResponse = mockk<ProductsResponse>()
        runTest {
            coEvery { remoteDataSource.getProducts(any()) } returns mockProductResponse
            repository.getProducts("makanan").map {
                delay(100)
                it
            }.test {
                delay(110)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Loading)
                coVerify { remoteDataSource.getProducts(any()) }
            }
        }
    }

    @Test
    fun `get products, with result success`() {
        val fakeProductItemResponse = ProductItemResponse(
            desc = "desc",
            id = 1,
            name = "name",
            price = 12000.0,
            productImgUrl = "url",
            rating = 5.0,
            supplierName = "Supplier",
            weightInKg = 1.0
        )
        val fakeProductsResponse = ProductsResponse(
            code = 200,
            status = true,
            message = "Success",
            data = listOf(fakeProductItemResponse)
        )
        runTest {
            coEvery { remoteDataSource.getProducts(any()) } returns fakeProductsResponse
            repository.getProducts("sembarang").map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Success)
                assertEquals(data.payload?.size, 1)
                assertEquals(data.payload?.get(0)?.id, 1)
                coVerify { remoteDataSource.getProducts(any()) }
            }
        }
    }

    @Test
    fun `get products, with result empty`() {
        val fakeProductsResponse = ProductsResponse(
            code = 200,
            status = true,
            message = "Success",
            data = emptyList()
        )
        runTest {
            coEvery { remoteDataSource.getProducts(any()) } returns fakeProductsResponse
            repository.getProducts().map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Empty)
                coVerify { remoteDataSource.getProducts(any()) }
            }
        }
    }

    @Test
    fun `get products, with result error`() {
        runTest {
            coEvery { remoteDataSource.getProducts(any()) } throws IllegalStateException("Mock error")
            repository.getProducts("bebas").map {
                delay(100)
                it
            }.test {
                delay(220)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Error)
                coVerify { remoteDataSource.getProducts(any()) }
            }
        }
    }
}
