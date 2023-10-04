package com.catnip.egroceries.presentation.common.adapter

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.catnip.egroceries.R
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemCartProductBinding
import com.catnip.egroceries.databinding.ItemCartProductOrderBinding
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct
import com.catnip.egroceries.utils.doneEditing

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class CartListAdapter(private val cartListener: CartListener? = null) :
    RecyclerView.Adapter<ViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<CartProduct>() {
            override fun areItemsTheSame(
                oldItem: CartProduct,
                newItem: CartProduct
            ): Boolean {
                return oldItem.cart.id == newItem.cart.id && oldItem.product.id == newItem.product.id
            }

            override fun areContentsTheSame(
                oldItem: CartProduct,
                newItem: CartProduct
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        })

    fun submitData(data: List<CartProduct>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (cartListener != null) CartViewHolder(
            ItemCartProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), cartListener
        ) else CartOrderViewHolder(
            ItemCartProductOrderBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolderBinder<CartProduct>).bind(dataDiffer.currentList[position])
    }

}

class CartViewHolder(
    private val binding: ItemCartProductBinding,
    private val cartListener: CartListener?
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<CartProduct> {
    override fun bind(item: CartProduct) {
        setCartData(item)
        setCartNotes(item)
        setClickListeners(item)
    }

    private fun setCartData(item: CartProduct) {
        with(binding) {
            binding.ivProductImage.load(item.product.productImgUrl) {
                crossfade(true)
            }
            tvProductCount.text = item.cart.itemQuantity.toString()
            tvProductName.text = item.product.name
            tvProductPrice.text = (item.cart.itemQuantity * item.product.price).toString()
        }
    }

    private fun setCartNotes(item: CartProduct) {
        binding.etNotesItem.setText(item.cart.itemNotes)
        binding.etNotesItem.doneEditing {
            binding.etNotesItem.clearFocus()
            val newItem = item.cart.copy().apply {
                itemNotes = binding.etNotesItem.text.toString().trim()
            }
            cartListener?.onUserDoneEditingNotes(newItem)
        }
    }

    private fun setClickListeners(item: CartProduct) {
        with(binding) {
            ivMinus.setOnClickListener { cartListener?.onMinusTotalItemCartClicked(item.cart) }
            ivPlus.setOnClickListener { cartListener?.onPlusTotalItemCartClicked(item.cart) }
            ivRemoveCart.setOnClickListener { cartListener?.onRemoveCartClicked(item.cart) }
        }
    }
}

class CartOrderViewHolder(
    private val binding: ItemCartProductOrderBinding,
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<CartProduct> {
    override fun bind(item: CartProduct) {
        setCartData(item)
        setCartNotes(item)
    }

    private fun setCartData(item: CartProduct) {
        with(binding) {
            binding.ivProductImage.load(item.product.productImgUrl) {
                crossfade(true)
            }
            tvTotalQuantity.text =
                itemView.rootView.context.getString(
                    R.string.total_quantity,
                    item.cart.itemQuantity.toString()
                )
            tvProductName.text = item.product.name
            tvProductPrice.text = (item.cart.itemQuantity * item.product.price).toString()
        }
    }

    private fun setCartNotes(item: CartProduct) {
        binding.tvNotes.text = item.cart.itemNotes
    }

}


interface CartListener {
    fun onPlusTotalItemCartClicked(cart: Cart)
    fun onMinusTotalItemCartClicked(cart: Cart)
    fun onRemoveCartClicked(cart: Cart)
    fun onUserDoneEditingNotes(cart: Cart)
}