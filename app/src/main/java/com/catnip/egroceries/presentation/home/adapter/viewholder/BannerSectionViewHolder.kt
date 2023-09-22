package com.catnip.egroceries.presentation.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemSectionBannerHomeBinding
import com.catnip.egroceries.databinding.ItemSectionHeaderHomeBinding
import com.catnip.egroceries.presentation.home.adapter.model.HomeSection

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class BannerSectionViewHolder(
    private val binding : ItemSectionBannerHomeBinding
) : RecyclerView.ViewHolder(binding.root),ViewHolderBinder<HomeSection>{
    override fun bind(item: HomeSection) {
        if(item is HomeSection.BannerSection){
            //no-op
        }
    }
}