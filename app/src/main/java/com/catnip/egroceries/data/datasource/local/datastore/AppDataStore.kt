package com.catnip.egroceries.data.datasource.local.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
val Context.appDataStore by preferencesDataStore(
    //TODO : Change with your own preference app name
    name = "DataStoreExample"
)