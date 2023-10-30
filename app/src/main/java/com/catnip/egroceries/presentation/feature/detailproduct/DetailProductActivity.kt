package com.catnip.egroceries.presentation.feature.detailproduct

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.catnip.egroceries.data.local.database.AppDatabase
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.datasource.CartDatabaseDataSource
import com.catnip.egroceries.data.network.api.datasource.EGroceriesApiDataSource
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService
import com.catnip.egroceries.data.repository.CartRepository
import com.catnip.egroceries.data.repository.CartRepositoryImpl
import com.catnip.egroceries.databinding.ActivityDetailProductBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.proceedWhen
import com.catnip.egroceries.utils.toCurrencyFormat
import com.chuckerteam.chucker.api.ChuckerInterceptor

class DetailProductActivity : AppCompatActivity() {

    private val binding: ActivityDetailProductBinding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailProductViewModel by viewModels {
        val database = AppDatabase.getInstance(this)
        val cartDao = database.cartDao()
        val cartDataSource: CartDataSource = CartDatabaseDataSource(cartDao)
        val chuckerInterceptor = ChuckerInterceptor(this.applicationContext)
        val service = EGroceriesApiService.invoke(chuckerInterceptor)
        val apiDataSource = EGroceriesApiDataSource(service)
        val repo: CartRepository = CartRepositoryImpl(cartDataSource, apiDataSource)
        GenericViewModelFactory.create(
            DetailProductViewModel(intent?.extras, repo)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindProduct(viewModel.product)
        observeData()
        setClickListener()
    }

    private fun setClickListener() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.ivMinus.setOnClickListener {
            viewModel.minus()
        }
        binding.ivPlus.setOnClickListener {
            viewModel.add()
        }
        binding.btnAddToCart.setOnClickListener {
            viewModel.addToCart()
        }
    }

    private fun observeData() {
        viewModel.priceLiveData.observe(this) {
            binding.tvCalculatedProductPrice.text = it.toCurrencyFormat()
        }
        viewModel.productCountLiveData.observe(this) {
            binding.tvProductCount.text = it.toString()
        }
        viewModel.addToCartResult.observe(this) {
            it.proceedWhen(
                doOnSuccess = {
                    Toast.makeText(this, "Add to cart success !", Toast.LENGTH_SHORT).show()
                    finish()
                },
                doOnError = {
                    Toast.makeText(this, it.exception?.message.orEmpty(), Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    private fun bindProduct(product: Product?) {
        product?.let { item ->
            binding.ivProductImage.load(item.productImgUrl) {
                crossfade(true)
            }
            binding.tvProductName.text = item.name
            binding.tvProductDesc.text = item.desc
            binding.tvProductPrice.text = item.price.toCurrencyFormat()
            binding.tvProductRating.text = item.rating.toString()
            binding.tvProductFarm.text = item.supplierName
        }
    }

    companion object {
        const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
        fun startActivity(context: Context, product: Product) {
            val intent = Intent(context, DetailProductActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, product)
            context.startActivity(intent)
        }
    }
}
