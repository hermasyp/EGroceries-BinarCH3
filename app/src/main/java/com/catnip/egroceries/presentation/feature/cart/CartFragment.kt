package com.catnip.egroceries.presentation.feature.cart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.catnip.egroceries.R
import com.catnip.egroceries.data.local.database.AppDatabase
import com.catnip.egroceries.data.local.database.datasource.CartDataSource
import com.catnip.egroceries.data.local.database.datasource.CartDatabaseDataSource
import com.catnip.egroceries.data.repository.CartRepository
import com.catnip.egroceries.data.repository.CartRepositoryImpl
import com.catnip.egroceries.databinding.FragmentCartBinding
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct
import com.catnip.egroceries.presentation.common.adapter.CartListAdapter
import com.catnip.egroceries.presentation.common.adapter.CartListener
import com.catnip.egroceries.presentation.feature.checkout.CheckoutActivity
import com.catnip.egroceries.utils.GenericViewModelFactory
import com.catnip.egroceries.utils.hideKeyboard
import com.catnip.egroceries.utils.proceedWhen
import com.catnip.egroceries.utils.toCurrencyFormat

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    private val viewModel: CartViewModel by viewModels {
        val database = AppDatabase.getInstance(requireContext())
        val cartDao = database.cartDao()
        val cartDataSource: CartDataSource = CartDatabaseDataSource(cartDao)
        val repo: CartRepository = CartRepositoryImpl(cartDataSource)
        GenericViewModelFactory.create(CartViewModel(repo))
    }

    private val adapter: CartListAdapter by lazy {
        CartListAdapter(object : CartListener {
            override fun onPlusTotalItemCartClicked(cart: Cart) {
                //todo : add quantity cart item
            }

            override fun onMinusTotalItemCartClicked(cart: Cart) {
                viewModel.decreaseCart(cart)
            }

            override fun onRemoveCartClicked(cart: Cart) {
                //todo : remove cart item
            }

            override fun onUserDoneEditingNotes(cart: Cart) {
                //todo : edit notes cart item
            }
        })
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
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnCheckout.setOnClickListener {
            context?.startActivity(Intent(requireContext(), CheckoutActivity::class.java))
        }
    }

    private fun setupList() {
        binding.rvCart.itemAnimator = null
        binding.rvCart.adapter = adapter
    }

    private fun observeData() {
        viewModel.cartList.observe(viewLifecycleOwner) { result ->
            result.proceedWhen(
                doOnSuccess = {
                    binding.rvCart.isVisible = true
                    binding.layoutState.root.isVisible = false
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = false
                    result.payload?.let { (carts,totalPrice) ->
                        adapter.submitData(carts)
                        binding.tvTotalPrice.text = totalPrice.toCurrencyFormat()
                    }
                },
                doOnError = { err ->
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.tvError.isVisible = true
                    binding.layoutState.tvError.text = err.exception?.message.orEmpty()
                    binding.layoutState.pbLoading.isVisible = false
                },
                doOnLoading = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.tvError.isVisible = false
                    binding.layoutState.pbLoading.isVisible = true
                    binding.rvCart.isVisible = false
                },
                doOnEmpty = {
                    //todo : add empty state
                }
            )
        }
    }

}