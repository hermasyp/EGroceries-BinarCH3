package com.catnip.egroceries.presentation.home

import android.R.attr.spacing
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.egroceries.data.datasource.CategoryDataSource
import com.catnip.egroceries.data.datasource.CategoryDataSourceImpl
import com.catnip.egroceries.data.datasource.ProductDataSource
import com.catnip.egroceries.data.datasource.ProductDataSourceImpl
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import com.catnip.egroceries.databinding.ActivityHomeBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.detailproduct.DetailProductActivity
import com.catnip.egroceries.presentation.home.adapter.HomeAdapter
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.GridSpacingItemDecoration


class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private val adapter: HomeAdapter by lazy {
        HomeAdapter {
            navigateToDetail(it)
        }
    }

    private fun navigateToDetail(item: Product) {
        DetailProductActivity.startActivity(this, item)
    }

    private val viewModel: HomeViewModel by viewModels {
        val cds: CategoryDataSource = CategoryDataSourceImpl()
        val pds: ProductDataSource = ProductDataSourceImpl()
        val repo: ProductRepository = ProductRepositoryImpl(cds, pds)
        GenericViewModelFactory.create(HomeViewModel(repo))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupList()
    }

    private fun setupList() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = this@HomeActivity.adapter
        }
        adapter.setItems(viewModel.getHomeSectionData())
    }
}