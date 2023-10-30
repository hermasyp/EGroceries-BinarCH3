package com.catnip.egroceries.presentation.feature.home.adapter.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemSectionCategoryBinding
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.presentation.feature.home.adapter.subadapter.CategoryListAdapter
import com.catnip.egroceries.utils.proceedWhen

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class CategoriesSectionViewHolder(
    private val binding: ItemSectionCategoryBinding,
    private val onCategoriesClicked: (Category) -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection> {
    private val adapter: CategoryListAdapter by lazy {
        CategoryListAdapter {
            onCategoriesClicked.invoke(it)
        }
    }
    override fun bind(item: HomeSection) {
        if (item is HomeSection.CategoriesSection) {
            item.data.proceedWhen(doOnSuccess = {
                binding.layoutState.root.isVisible = false
                binding.layoutState.pbLoading.isVisible = false
                binding.layoutState.tvError.isVisible = false
                binding.rvCategory.apply {
                    isVisible = true
                    adapter = this@CategoriesSectionViewHolder.adapter
                }
                item.data.payload?.let { data -> adapter.submitData(data) }
            }, doOnLoading = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = true
                    binding.layoutState.tvError.isVisible = false
                    binding.rvCategory.isVisible = false
                }, doOnError = {
                    binding.layoutState.root.isVisible = true
                    binding.layoutState.pbLoading.isVisible = false
                    binding.layoutState.tvError.isVisible = true
                    binding.layoutState.tvError.text = item.data.exception?.message.orEmpty()
                    binding.rvCategory.isVisible = false
                })
        }
    }
}
