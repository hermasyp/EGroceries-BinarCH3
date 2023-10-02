package com.catnip.egroceries.presentation.feature.checkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catnip.egroceries.R
import com.catnip.egroceries.databinding.ActivityCheckoutBinding

class CheckoutActivity : AppCompatActivity() {

    private val binding : ActivityCheckoutBinding by lazy {
        ActivityCheckoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}