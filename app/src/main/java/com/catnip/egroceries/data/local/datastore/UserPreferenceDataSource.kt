package com.catnip.egroceries.data.local.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import com.catnip.egroceries.utils.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.Flow

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface UserPreferenceDataSource {
    suspend fun getUserDarkModePref(): Boolean
    fun getUserDarkModePrefFlow(): Flow<Boolean>
    suspend fun setUserDarkModePref(isUsingDarkMode: Boolean)
}

class UserPreferenceDataSourceImpl(private val preferenceHelper: PreferenceDataStoreHelper) :
    UserPreferenceDataSource {

    override suspend fun getUserDarkModePref(): Boolean {
        return preferenceHelper.getFirstPreference(PREF_USER_DARK_MODE, false)
    }

    override fun getUserDarkModePrefFlow(): Flow<Boolean> {
        return preferenceHelper.getPreference(PREF_USER_DARK_MODE, false)
    }

    override suspend fun setUserDarkModePref(isUsingDarkMode: Boolean) {
        return preferenceHelper.putPreference(PREF_USER_DARK_MODE, isUsingDarkMode)
    }

    companion object {
        val PREF_USER_DARK_MODE = booleanPreferencesKey("PREF_USER_DARK_MODE")
    }
}