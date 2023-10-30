package com.catnip.egroceries.utils

import android.icu.text.NumberFormat
import android.icu.util.Currency
import kotlin.math.roundToInt

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

fun Double.toCurrencyFormat(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("IDR")
    return format.format(this.roundToInt())
}
