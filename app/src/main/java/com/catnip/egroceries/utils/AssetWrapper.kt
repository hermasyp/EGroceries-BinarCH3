package com.catnip.egroceries.utils

import android.content.Context
import androidx.annotation.StringRes

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class AssetWrapper(private val appContext: Context) {
    fun getString(@StringRes id: Int): String {
        return appContext.getString(id)
    }
}