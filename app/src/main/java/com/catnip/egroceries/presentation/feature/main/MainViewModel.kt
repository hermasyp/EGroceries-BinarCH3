package com.catnip.egroceries.presentation.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.catnip.egroceries.data.local.datastore.UserPreferenceDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreferenceDataSource: UserPreferenceDataSource
) : ViewModel() {
    val userDarkModeLiveData = userPreferenceDataSource.getUserDarkModePrefFlow().asLiveData(
        Dispatchers.IO
    )
}
