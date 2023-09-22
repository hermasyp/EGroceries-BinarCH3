package com.catnip.egroceries.presentation.home.adapter.subadapter;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.egroceries.databinding.ItemProductBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.utils.toCurrencyFormat

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ProductListAdapter(private val itemClick: (Product) -> Unit) :
    RecyclerView.Adapter<ProductListAdapter.ItemProductViewHolder>() {

    private var items: MutableList<Product> = mutableListOf()

    fun setItems(items: List<Product>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Product>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemProductViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: ItemProductViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size


    class ItemProductViewHolder(
        private val binding: ItemProductBinding,
        val itemClick: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Product) {
            with(item) {
                binding.ivProductImage.load(item.productImgUrl){
                    crossfade(true)
                }
                binding.tvProductName.text = item.name
                binding.tvProductPrice.text = item.price.toCurrencyFormat()
                binding.tvProductWeight.text = "${item.weightInKg} KG"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

}