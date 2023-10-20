package com.catnip.egroceries.presentation.feature.home2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.catnip.egroceries.R
import com.catnip.egroceries.data.network.api.datasource.EGroceriesApiDataSource
import com.catnip.egroceries.data.network.api.service.EGroceriesApiService
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import com.catnip.egroceries.databinding.FragmentHome2Binding
import com.catnip.egroceries.presentation.feature.home.HomeViewModel
import com.catnip.egroceries.presentation.feature.home.adapter.subadapter.CategoryListAdapter
import com.catnip.egroceries.presentation.feature.home.adapter.subadapter.ProductListAdapter
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.proceedWhen

class Home2Fragment : Fragment() {

    private lateinit var binding: FragmentHome2Binding

    private val categoryAdapter : CategoryListAdapter by lazy {
        CategoryListAdapter{
            viewModel.getProducts(it.slug)
        }
    }

    private val productAdapter : ProductListAdapter by lazy {
        ProductListAdapter{

        }
    }

    private val viewModel : Home2ViewModel by viewModels {
        val service = EGroceriesApiService.invoke()
        val dataSource = EGroceriesApiDataSource(service)
        val repo: ProductRepository =
            ProductRepositoryImpl(dataSource)
        GenericViewModelFactory.create(Home2ViewModel(repo))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHome2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        getData()
    }

    private fun getData() {
        viewModel.getCategories()
        viewModel.getProducts()
    }

    private fun observeData() {
        viewModel.categories.observe(viewLifecycleOwner){
            it.proceedWhen(doOnSuccess = {
                binding.layoutStateCategory.root.isVisible = false
                binding.layoutStateCategory.pbLoading.isVisible = false
                binding.layoutStateCategory.tvError.isVisible = false
                binding.rvCategory.apply {
                    isVisible = true
                    adapter = categoryAdapter
                }
                it.payload?.let { data -> categoryAdapter.submitData(data) }
            }, doOnLoading = {
                binding.layoutStateCategory.root.isVisible = true
                binding.layoutStateCategory.pbLoading.isVisible = true
                binding.layoutStateCategory.tvError.isVisible = false
                binding.rvCategory.isVisible = false
            }, doOnError = {
                binding.layoutStateCategory.root.isVisible = true
                binding.layoutStateCategory.pbLoading.isVisible = false
                binding.layoutStateCategory.tvError.isVisible = true
                binding.layoutStateCategory.tvError.text = it.exception?.message.orEmpty()
                binding.rvCategory.isVisible = false
            })
        }
        viewModel.products.observe(viewLifecycleOwner){
            it.proceedWhen(doOnSuccess = {
                binding.layoutStateProduct.root.isVisible = false
                binding.layoutStateProduct.pbLoading.isVisible = false
                binding.layoutStateProduct.tvError.isVisible = false
                binding.rvProductList.apply {
                    isVisible = true
                    adapter = productAdapter
                    itemAnimator = null
                }
                binding.rvProductList.smoothScrollToPosition(0)
                it.payload?.let { data -> productAdapter.submitData(data) }
            }, doOnLoading = {
                binding.layoutStateProduct.root.isVisible = true
                binding.layoutStateProduct.pbLoading.isVisible = true
                binding.layoutStateProduct.tvError.isVisible = false
                binding.rvProductList.isVisible = false
            }, doOnError = {
                binding.layoutStateProduct.root.isVisible = true
                binding.layoutStateProduct.pbLoading.isVisible = false
                binding.layoutStateProduct.tvError.isVisible = true
                binding.layoutStateProduct.tvError.text = it.exception?.message.orEmpty()
                binding.rvProductList.isVisible = false
            }, doOnEmpty = {
                binding.layoutStateProduct.root.isVisible = true
                binding.layoutStateProduct.pbLoading.isVisible = false
                binding.layoutStateProduct.tvError.isVisible = true
                binding.layoutStateProduct.tvError.text = "Product not found"
                binding.rvProductList.isVisible = false
            })
        }
    }
}