package com.catnip.egroceries.data.repository

import app.cash.turbine.test
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.entity.CartEntity
import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.utils.ResultWrapper
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class CartRepositoryImplTest {

    @MockK
    lateinit var localDataSource: CartDataSource

    @MockK
    lateinit var remoteDataSource: EGroceriesDataSource

    private lateinit var repository: CartRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository = CartRepositoryImpl(localDataSource, remoteDataSource)
    }

    @Test
    fun deleteAll() {
        coEvery { localDataSource.deleteAll() } returns Unit
        runTest {
            val result = repository.deleteAll()
            coVerify { localDataSource.deleteAll() }
            assertEquals(result, Unit)
        }
    }

    @Test
    fun `get user card data, result success`() {
        val fakeCartList = listOf(
            CartEntity(
                id = 1,
                productId = 1,
                productName = "Sate Cirebon",
                productPrice = 12000.0,
                productImgUrl = "url",
                itemQuantity = 2,
                itemNotes = "notes"
            ),
            CartEntity(
                id = 2,
                productId = 1,
                productName = "Sate Padang",
                productPrice = 14000.0,
                productImgUrl = "url",
                itemQuantity = 2,
                itemNotes = "notes"
            )
        )
        every { localDataSource.getAllCarts() } returns flow {
            emit(fakeCartList)
        }
        runTest {
            repository.getUserCardData().map {
                delay(100)
                it
            }.test {
                delay(2201)
                val data = expectMostRecentItem()
                assertTrue(data is ResultWrapper.Success)
                assertEquals(data.payload?.first?.size, 2)
                assertEquals(data.payload?.second, 52000.0)
                verify { localDataSource.getAllCarts() }
            }
        }
    }

    @Test
    fun `get user card data, result loading`() {
    }

    @Test
    fun `get user card data, result error`() {
    }

    @Test
    fun `get user card data, result empty`() {
    }
}
