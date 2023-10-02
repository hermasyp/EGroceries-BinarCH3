package com.catnip.egroceries.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.egroceries.data.dummy.CategoryDataSource
import com.catnip.egroceries.data.dummy.CategoryDataSourceImpl
import com.catnip.egroceries.data.dummy.DummyProductDataSource
import com.catnip.egroceries.data.dummy.DummyProductDataSourceImpl
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import com.catnip.egroceries.databinding.FragmentHomeBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.detailproduct.DetailProductActivity
import com.catnip.egroceries.presentation.home.adapter.HomeAdapter
import com.catnip.egroceries.utils.GenericViewModelFactory


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter: HomeAdapter by lazy {
        HomeAdapter(onProductClicked = {
            navigateToDetail(it)
        }, onSettingsClicked = {
            openSettingDialog()
        })
    }

    private fun openSettingDialog() {
        //SettingsDialogFragment().show(childFragmentManager,null)
    }

    private fun navigateToDetail(item: Product) {
        DetailProductActivity.startActivity(requireContext(), item)
    }

    private val viewModel: HomeViewModel by viewModels {
        val cds: CategoryDataSource = CategoryDataSourceImpl()
        val pds: DummyProductDataSource = DummyProductDataSourceImpl()
        val repo: ProductRepository = ProductRepositoryImpl(cds, pds)
        GenericViewModelFactory.create(HomeViewModel(repo))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }


    private fun setupList() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@HomeFragment.adapter
        }
        adapter.setItems(viewModel.getHomeSectionData())
    }
}