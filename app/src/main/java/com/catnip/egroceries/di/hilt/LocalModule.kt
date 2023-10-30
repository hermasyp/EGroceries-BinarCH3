package com.catnip.egroceries.di.hilt

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.catnip.egroceries.data.local.database.AppDatabase
import com.catnip.egroceries.data.local.database.dao.CartDao
import com.catnip.egroceries.data.local.datastore.appDataStore
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
import com.catnip.egroceries.utils.PreferenceDataStoreHelperImpl
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
object LocalModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideCartDao(appDatabase: AppDatabase): CartDao {
        return appDatabase.cartDao()
    }

    @Singleton
    @Provides
    fun provideAppDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.appDataStore
    }

    @Singleton
    @Provides
    fun providePreferenceDataStoreHelper(preference: DataStore<Preferences>): PreferenceDataStoreHelper {
        return PreferenceDataStoreHelperImpl(preference)
    }
}
