package com.catnip.egroceries.presentation.common.adapter

import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemCartProductBinding
import com.catnip.egroceries.model.Cart
import com.catnip.egroceries.model.CartProduct

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class CartListAdapter(private val cartListener: CartListener) :
    RecyclerView.Adapter<CartViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemCartProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), cartListener
        )
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        (holder as ViewHolderBinder<CartProduct>).bind(dataDiffer.currentList[position])
    }

}

class CartViewHolder(
    private val binding: ItemCartProductBinding,
    private val cartListener: CartListener
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<CartProduct> {
    override fun bind(item: CartProduct) {
        setCartData(item)
        setCartNotes(item)
        setClickListeners(item)
    }

    private fun setCartData(item: CartProduct) {
        with(binding) {
            binding.ivProductImage.load(item.product.productImgUrl){
                crossfade(true)
            }
            tvProductCount.text = item.cart.itemQuantity.toString()
            tvProductName.text = item.product.name
            tvProductPrice.text = (item.cart.itemQuantity * item.product.price).toString()
        }
    }

    private fun setCartNotes(item: CartProduct) {
        binding.etNotesItem.setText(item.cart.itemNotes)
        binding.etNotesItem.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                event != null &&
                event.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                if (event == null || !event.isShiftPressed) {
                    // the user is done typing.
                    val newItem = item.cart.apply {
                        itemNotes = binding.etNotesItem.text.toString().trim()
                    }
                    cartListener.onUserDoneEditingNotes(newItem)
                    return@setOnEditorActionListener true
                }
            }
            return@setOnEditorActionListener true
        }
    }

    private fun setClickListeners(item: CartProduct) {
        with(binding) {
            ivMinus.setOnClickListener { cartListener.onMinusTotalItemCartClicked(item.cart) }
            ivPlus.setOnClickListener { cartListener.onPlusTotalItemCartClicked(item.cart) }
            ivRemoveCart.setOnClickListener { cartListener.onRemoveCartClicked(item.cart) }
            itemView.setOnClickListener { cartListener.onCartClicked(item) }
        }
    }
}

interface CartListener {
    fun onCartClicked(item: CartProduct)
    fun onPlusTotalItemCartClicked(cart: Cart)
    fun onMinusTotalItemCartClicked(cart: Cart)
    fun onRemoveCartClicked(cart: Cart)
    fun onUserDoneEditingNotes(newCart: Cart)
}