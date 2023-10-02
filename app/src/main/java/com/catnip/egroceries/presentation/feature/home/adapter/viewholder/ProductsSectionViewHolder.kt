package com.catnip.egroceries.presentation.feature.home.adapter.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemSectionProductListBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.presentation.feature.home.adapter.subadapter.ProductListAdapter
import com.catnip.egroceries.utils.GridSpacingItemDecoration
import com.catnip.egroceries.utils.proceedWhen

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class ProductsSectionViewHolder(
    private val binding: ItemSectionProductListBinding,
    private val onClickListener: (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection> {
    private val itemDecoration = GridSpacingItemDecoration(2, 48, true)
    init {
        binding.rvProductList.addItemDecoration(itemDecoration)
    }
    private val adapter: ProductListAdapter by lazy {
        ProductListAdapter {
            onClickListener.invoke(it)
        }
    }

    override fun bind(item: HomeSection) {
        if (item is HomeSection.ProductsSection) {
            item.data.proceedWhen(doOnSuccess = {
                binding.pbLoading.isVisible = false
                binding.tvError.isVisible = false
                binding.rvProductList.apply {
                    isVisible = true
                    adapter = this@ProductsSectionViewHolder.adapter
                }
                item.data.payload?.let { data -> adapter.submitData(data) }
            }, doOnLoading = {
                binding.pbLoading.isVisible = true
                binding.tvError.isVisible = false
                binding.rvProductList.isVisible = false
            }, doOnError = {
                binding.pbLoading.isVisible = false
                binding.tvError.isVisible = true
                binding.tvError.text = item.data.exception?.message.orEmpty()
                binding.rvProductList.isVisible = false
            })
        }
    }
}