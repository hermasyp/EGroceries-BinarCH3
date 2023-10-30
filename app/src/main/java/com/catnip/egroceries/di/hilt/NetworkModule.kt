package com.catnip.egroceries.di.hilt

import android.content.Context
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideEGroceriesApiService(chuckerInterceptor: ChuckerInterceptor): EGroceriesApiService {
        return EGroceriesApiService.invoke(chuckerInterceptor)
    }
}
