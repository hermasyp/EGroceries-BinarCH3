package com.catnip.egroceries.presentation.detailproduct

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import com.catnip.egroceries.R
import com.catnip.egroceries.data.datasource.CategoryDataSource
import com.catnip.egroceries.data.datasource.CategoryDataSourceImpl
import com.catnip.egroceries.data.datasource.ProductDataSource
import com.catnip.egroceries.data.datasource.ProductDataSourceImpl
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import com.catnip.egroceries.databinding.ActivityDetailProductBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.home.HomeViewModel
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.toCurrencyFormat

class DetailProductActivity : AppCompatActivity() {

    private val binding: ActivityDetailProductBinding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailProductViewModel by viewModels {
        GenericViewModelFactory.create(DetailProductViewModel(intent?.extras))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        bindProduct(viewModel.product)
        observeData()
        setClickListener()
    }

    private fun setClickListener() {

        binding.ivMinus.setOnClickListener{
            viewModel.minus()
        }
        binding.ivPlus.setOnClickListener{
            viewModel.add()
        }
    }

    private fun observeData() {
        viewModel.priceLiveData.observe(this){
            binding.tvProductPrice.text = it.toCurrencyFormat()
        }
        viewModel.productCountLiveData.observe(this){
            binding.tvProductCount.text = it.toString()
        }
    }

    private fun bindProduct(product: Product?) {
        product?.let { item ->
            binding.ivProductImage.load(item.productImgUrl) {
                crossfade(true)
            }
            binding.tvProductName.text = item.name
            binding.tvProductDesc.text = item.desc
            binding.tvProductRating.text = item.rating.toString()
            binding.tvProductPrice.text = item.price.toCurrencyFormat()
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