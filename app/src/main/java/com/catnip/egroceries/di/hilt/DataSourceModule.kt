package com.catnip.egroceries.di.hilt

import com.catnip.egroceries.data.local.database.dao.CartDao
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.datasource.CartDatabaseDataSource
import com.catnip.egroceries.data.local.datastore.UserPreferenceDataSource
import com.catnip.egroceries.data.local.datastore.UserPreferenceDataSourceImpl
import com.catnip.egroceries.data.network.api.datasource.EGroceriesApiDataSource
import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
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
object DataSourceModule {

    @Singleton
    @Provides
    fun provideCartDataSource(cartDao: CartDao): CartDataSource {
        return CartDatabaseDataSource(cartDao)
    }

    @Singleton
    @Provides
    fun provideUserPreferenceDataSource(preferenceHelper: PreferenceDataStoreHelper): UserPreferenceDataSource {
        return UserPreferenceDataSourceImpl(preferenceHelper)
    }

    @Singleton
    @Provides
    fun provideEGroceriesDataSource(service: EGroceriesApiService): EGroceriesDataSource {
        return EGroceriesApiDataSource(service)
    }
}
