package com.catnip.egroceries.presentation.home.adapter.viewholder

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemSectionCategoryBinding
import com.catnip.egroceries.databinding.ItemSectionProductListBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.home.adapter.model.HomeSection
import com.catnip.egroceries.presentation.home.adapter.subadapter.CategoryListAdapter
import com.catnip.egroceries.presentation.home.adapter.subadapter.ProductListAdapter
import com.catnip.egroceries.utils.GridSpacingItemDecoration

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ProductsSectionViewHolder(
    private val binding: ItemSectionProductListBinding,
    private val onClickListener : (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection> {
    private val adapter: ProductListAdapter by lazy {
        ProductListAdapter {
            onClickListener.invoke(it)
        }
    }
    override fun bind(item: HomeSection) {
        if(item is HomeSection.ProductsSection){
            binding.rvProductList.apply {
                adapter = this@ProductsSectionViewHolder.adapter
                addItemDecoration(GridSpacingItemDecoration(2, 48, true))
            }
            adapter.setItems(items = item.data)
        }
    }
}