package com.catnip.egroceries.data.local.database.datasource

import app.cash.turbine.test
import com.catnip.egroceries.data.local.database.dao.CartDao
import com.catnip.egroceries.data.local.database.entity.CartEntity
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class CartDatabaseDataSourceTest {

    @MockK
    lateinit var cartDao: CartDao

    private lateinit var cartDataSource: CartDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        cartDataSource = CartDatabaseDataSource(cartDao)
    }

    @Test
    fun getAllCarts() {
        runTest {
            val itemOneMock = mockk<CartEntity>()
            val itemTwoMock = mockk<CartEntity>()
            val listMock = listOf(
                itemOneMock,
                itemTwoMock
            )

            val flowMock = flow {
                emit(listMock)
            }

            every { cartDao.getAllCarts() } returns flowMock

            cartDataSource.getAllCarts().test {
                assertEquals(listMock, awaitItem())
                assertEquals(listMock[0], itemOneMock)
                assertEquals(listMock[1], itemTwoMock)
                awaitComplete()
            }
        }
    }

    @Test
    fun getCartById() {
        runTest {
            val itemOneMock = mockk<CartEntity>()
            val flowMock = flow {
                emit(itemOneMock)
            }
            every { cartDao.getCartById(any()) } returns flowMock
            cartDataSource.getCartById(123).test {
                assertEquals(itemOneMock, awaitItem())
                awaitComplete()
            }
        }
    }

    @Test
    fun insertCart() {
        runTest {
            val itemOneMock = mockk<CartEntity>()
            coEvery { cartDao.insertCart(any()) } returns 1
            val result = cartDataSource.insertCart(itemOneMock)
            assertEquals(result, 1)
        }
    }

    @Test
    fun deleteCart() {
        runTest {
            val itemOneMock = mockk<CartEntity>()
            coEvery { cartDao.deleteCart(any()) } returns 1
            val result = cartDataSource.deleteCart(itemOneMock)
            assertEquals(result, 1)
        }
    }

    @Test
    fun updateCart() {
        runTest {
            val itemOneMock = mockk<CartEntity>()
            coEvery { cartDao.updateCart(any()) } returns 1
            val result = cartDataSource.updateCart(itemOneMock)
            assertEquals(result, 1)
        }
    }

    @Test
    fun deleteAll() {
        runTest {
            coEvery { cartDao.deleteAll() } returns Unit
            cartDataSource.deleteAll()
            coVerify { cartDao.deleteAll() }
        }
    }
}
