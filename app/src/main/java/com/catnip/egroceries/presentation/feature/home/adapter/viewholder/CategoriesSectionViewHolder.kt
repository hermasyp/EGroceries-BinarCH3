package com.catnip.egroceries.presentation.feature.home.adapter.viewholder

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemSectionCategoryBinding
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.presentation.feature.home.adapter.subadapter.CategoryListAdapter

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class CategoriesSectionViewHolder(
    private val binding: ItemSectionCategoryBinding
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection> {
    private val adapter: CategoryListAdapter by lazy {
        CategoryListAdapter {
            Toast.makeText(binding.root.context, it.name, Toast.LENGTH_SHORT).show()
        }
    }
    override fun bind(item: HomeSection) {
        if(item is HomeSection.CategoriesSection){
            binding.rvCategory.apply {
                adapter = this@CategoriesSectionViewHolder.adapter
            }
            adapter.setItems(items = item.data)
        }
    }
}