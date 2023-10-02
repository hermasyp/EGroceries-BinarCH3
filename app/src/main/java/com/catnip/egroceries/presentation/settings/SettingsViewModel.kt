package com.catnip.egroceries.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.egroceries.data.local.datastore.UserPreferenceDataSource
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SettingsViewModel(private val userPreferenceDataSource: UserPreferenceDataSource) : ViewModel() {

    fun setUserDarkModePref(isUsingDarkMode: Boolean) {
        viewModelScope.launch {
            userPreferenceDataSource.setUserDarkModePref(isUsingDarkMode)
        }
    }

}