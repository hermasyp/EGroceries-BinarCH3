package com.catnip.egroceries.presentation.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemEmptyViewHolderBinding
import com.catnip.egroceries.databinding.ItemSectionBannerHomeBinding
import com.catnip.egroceries.databinding.ItemSectionCategoryBinding
import com.catnip.egroceries.databinding.ItemSectionHeaderHomeBinding
import com.catnip.egroceries.databinding.ItemSectionProductListBinding
import com.catnip.egroceries.model.Category
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.feature.home.adapter.model.HomeSection
import com.catnip.egroceries.presentation.feature.home.adapter.viewholder.BannerSectionViewHolder
import com.catnip.egroceries.presentation.feature.home.adapter.viewholder.CategoriesSectionViewHolder
import com.catnip.egroceries.presentation.feature.home.adapter.viewholder.EmptyViewHolder
import com.catnip.egroceries.presentation.feature.home.adapter.viewholder.HeaderSectionViewHolder
import com.catnip.egroceries.presentation.feature.home.adapter.viewholder.ProductsSectionViewHolder

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class HomeAdapter(
    private val onProductClicked: (Product) -> Unit,
    private val onCategoriesClicked: (Category) -> Unit,
    private val onSettingsClicked: () -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<HomeSection>() {
                override fun areItemsTheSame(
                    oldItem: HomeSection,
                    newItem: HomeSection
                ): Boolean {
                    return oldItem.id == newItem.id
                }
                override fun areContentsTheSame(
                    oldItem: HomeSection,
                    newItem: HomeSection
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    fun submitData(data: List<HomeSection>) {
        dataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ITEM_TYPE_HEADER -> {
                HeaderSectionViewHolder(
                    ItemSectionHeaderHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onSettingsClicked
                )
            }

            ITEM_TYPE_BANNER -> {
                BannerSectionViewHolder(
                    ItemSectionBannerHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ITEM_TYPE_CATEGORY_LIST -> {
                CategoriesSectionViewHolder(
                    ItemSectionCategoryBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onCategoriesClicked
                )
            }

            ITEM_TYPE_PRODUCT_LIST -> {
                ProductsSectionViewHolder(
                    ItemSectionProductListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onProductClicked
                )
            }

            else -> EmptyViewHolder(
                ItemEmptyViewHolderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolderBinder<HomeSection>).bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun getItemViewType(position: Int): Int {
        return when (dataDiffer.currentList[position]) {
            HomeSection.HeaderSection -> ITEM_TYPE_HEADER
            HomeSection.BannerSection -> ITEM_TYPE_BANNER
            is HomeSection.CategoriesSection -> ITEM_TYPE_CATEGORY_LIST
            is HomeSection.ProductsSection -> ITEM_TYPE_PRODUCT_LIST
        }
    }

    companion object {
        const val ITEM_TYPE_HEADER = 1
        const val ITEM_TYPE_BANNER = 2
        const val ITEM_TYPE_CATEGORY_LIST = 3
        const val ITEM_TYPE_PRODUCT_LIST = 4
    }
}
