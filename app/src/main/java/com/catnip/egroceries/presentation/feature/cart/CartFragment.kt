package com.catnip.egroceries.presentation.feature.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.catnip.egroceries.R
import com.catnip.egroceries.data.dummy.DummyCategoryDataSource
import com.catnip.egroceries.data.dummy.DummyCategoryDataSourceImpl
import com.catnip.egroceries.data.local.database.AppDatabase
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.datasource.CartDatabaseDataSource
import com.catnip.egroceries.data.local.database.datasource.ProductDatabaseDataSource
import com.catnip.egroceries.data.repository.CartRepository
import com.catnip.egroceries.data.repository.CartRepositoryImpl
import com.catnip.egroceries.data.repository.ProductRepository
import com.catnip.egroceries.data.repository.ProductRepositoryImpl
import com.catnip.egroceries.databinding.FragmentCartBinding
import com.catnip.egroceries.databinding.FragmentProfileBinding
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct
import com.catnip.egroceries.presentation.common.adapter.CartListAdapter
import com.catnip.egroceries.presentation.common.adapter.CartListener
import com.catnip.egroceries.presentation.feature.home.HomeViewModel
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.proceedWhen

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    private val adapter: CartListAdapter by lazy {
        CartListAdapter(object : CartListener {
            override fun onCartClicked(item: CartProduct) {

            }

            override fun onPlusTotalItemCartClicked(cart: Cart) {

            }

            override fun onMinusTotalItemCartClicked(cart: Cart) {

            }

            override fun onRemoveCartClicked(cart: Cart) {

            }

            override fun onUserDoneEditingNotes(newCart: Cart) {

            }
        })
    }


    private val viewModel: CartViewModel by viewModels {
        val database = AppDatabase.getInstance(requireContext())
        val cartDao = database.cartDao()
        val cartDataSource: CartDataSource = CartDatabaseDataSource(cartDao)
        val repo: CartRepository = CartRepositoryImpl(cartDataSource)
        GenericViewModelFactory.create(CartViewModel(repo))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        observeData()

    }

    private fun setupList() {
        binding.rvCart.adapter = adapter
    }

    private fun observeData() {
        viewModel.cartList.observe(viewLifecycleOwner) {
            it.proceedWhen(doOnSuccess = { result ->
                result.payload?.let { data -> adapter.submitData(data) }
            })
        }
    }

}