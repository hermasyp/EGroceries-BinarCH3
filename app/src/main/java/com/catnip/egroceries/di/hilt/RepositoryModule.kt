package com.catnip.egroceries.di.hilt

import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.data.repository.CartRepository
import com.catnip.egroceries.data.repository.CartRepositoryImpl
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCartRepository(
        cartDataSource: CartDataSource,
        eGroceriesDataSource: EGroceriesDataSource
    ): CartRepository {
        return CartRepositoryImpl(cartDataSource, eGroceriesDataSource)
    }

    @Singleton
    @Provides
    fun provideProductRepository(
        eGroceriesDataSource: EGroceriesDataSource
    ): ProductRepository {
        return ProductRepositoryImpl(eGroceriesDataSource)
    }
}
