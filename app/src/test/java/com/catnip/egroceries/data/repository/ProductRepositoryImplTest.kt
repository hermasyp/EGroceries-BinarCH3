package com.catnip.egroceries.data.repository

import app.cash.turbine.test
import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.data.network.api.model.category.CategoriesResponse
import com.catnip.egroceries.data.network.api.model.category.toCategoryList
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class ProductRepositoryImplTest {

    @MockK
    lateinit var dataSource: EGroceriesDataSource

    private lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = ProductRepositoryImpl(dataSource)
    }

    @Test
    fun getCategoriesSuccess() {
        runTest {
            val categoriesResponseMock = mockk<CategoriesResponse>(relaxed = true)
            val categoryItemOneMock = mockk<Category>(relaxed = true)
            val categoryItemTwoMock = mockk<Category>(relaxed = true)
            val categoriesListMock = arrayListOf(
                categoryItemOneMock,
                categoryItemTwoMock
            )
            coEvery { dataSource.getCategories() } returns categoriesResponseMock
            every { categoriesResponseMock.data } returns mockk()
            every { categoriesResponseMock.data?.toCategoryList() } returns categoriesListMock
            repository.getCategories().map {
                delay(100)
                it
            }.test {
                delay(210)
                assertTrue(awaitItem() is ResultWrapper.Success)
            }
        }
    }

    @Test
    fun getCategoriesEmpty() {
    }

    @Test
    fun getCategoriesFailed() {
    }

    @Test
    fun getProductsSuccess() {
    }

    @Test
    fun getProductsEmpty() {
    }

    @Test
    fun getProductsFailed() {
    }
}
