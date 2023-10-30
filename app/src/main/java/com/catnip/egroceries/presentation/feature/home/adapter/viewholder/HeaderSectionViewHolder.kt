package com.catnip.egroceries.presentation.feature.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemSectionHeaderHomeBinding
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class HeaderSectionViewHolder(
    private val binding: ItemSectionHeaderHomeBinding,
    private val onSettingsClicked: () -> Unit
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<HomeSection> {
    override fun bind(item: HomeSection) {
        if (item is HomeSection.HeaderSection) {
            binding.ivSettings.setOnClickListener {
                onSettingsClicked.invoke()
            }
        }
    }
}
