package com.catnip.egroceries.di.koin

import com.catnip.egroceries.data.local.database.AppDatabase
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.datasource.CartDatabaseDataSource
import com.catnip.egroceries.data.local.datastore.UserPreferenceDataSource
import com.catnip.egroceries.data.local.datastore.UserPreferenceDataSourceImpl
import com.catnip.egroceries.data.local.datastore.appDataStore
import com.catnip.egroceries.data.network.api.datasource.EGroceriesApiDataSource
import com.catnip.egroceries.data.network.api.datasource.EGroceriesDataSource
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService
import com.catnip.egroceries.data.repository.CartRepository
import com.catnip.egroceries.data.repository.CartRepositoryImpl
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import com.catnip.egroceries.presentation.feature.cart.CartViewModel
import com.catnip.egroceries.presentation.feature.home.HomeViewModel
import com.catnip.egroceries.utils.AssetWrapper
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
import com.catnip.egroceries.utils.PreferenceDataStoreHelperImpl
import com.chuckerteam.chucker.api.ChuckerInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
object AppModules {

    private val localModule = module {
        single { AppDatabase.getInstance(androidContext()) }
        single { get<AppDatabase>().cartDao() }
        single { androidContext().appDataStore }
        single<PreferenceDataStoreHelper> { PreferenceDataStoreHelperImpl(get()) }
    }

    private val networkModule = module {
        single { ChuckerInterceptor(androidContext()) }
        single { EGroceriesApiService.invoke(get()) }
    }

    private val dataSourceModule = module {
        single<CartDataSource> { CartDatabaseDataSource(get()) }
        single<UserPreferenceDataSource> { UserPreferenceDataSourceImpl(get()) }
        single<EGroceriesDataSource> { EGroceriesApiDataSource(get()) }
    }

    private val repositoryModule = module {
        single<CartRepository> { CartRepositoryImpl(get(), get()) }
        single<ProductRepository> { ProductRepositoryImpl(get()) }
    }

    private val viewModelModule = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::CartViewModel)
    }

    private val utilsModule = module {
        single { AssetWrapper(androidContext()) }
    }

    val modules: List<Module> = listOf(
        localModule,
        networkModule,
        dataSourceModule,
        repositoryModule,
        viewModelModule,
        utilsModule
    )
}
