package com.catnip.egroceries.presentation.home.adapter;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.catnip.egroceries.core.ViewHolderBinder
import com.catnip.egroceries.databinding.ItemEmptyViewHolderBinding
import com.catnip.egroceries.databinding.ItemSectionBannerHomeBinding
import com.catnip.egroceries.databinding.ItemSectionCategoryBinding
import com.catnip.egroceries.databinding.ItemSectionHeaderHomeBinding
import com.catnip.egroceries.databinding.ItemSectionProductListBinding
import com.catnip.egroceries.model.Product
import com.catnip.egroceries.presentation.home.adapter.model.HomeSection
import com.catnip.egroceries.presentation.home.adapter.viewholder.BannerSectionViewHolder
import com.catnip.egroceries.presentation.home.adapter.viewholder.CategoriesSectionViewHolder
import com.catnip.egroceries.presentation.home.adapter.viewholder.EmptyViewHolder
import com.catnip.egroceries.presentation.home.adapter.viewholder.HeaderSectionViewHolder
import com.catnip.egroceries.presentation.home.adapter.viewholder.ProductsSectionViewHolder

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class HomeAdapter(
    private val onProductClicked: (Product) -> Unit,
    private val onSettingsClicked: () -> Unit
) : RecyclerView.Adapter<ViewHolder>() {
    private var items: MutableList<HomeSection> = mutableListOf()

    fun setItems(items: List<HomeSection>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<HomeSection>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ITEM_TYPE_HEADER -> {
                HeaderSectionViewHolder(
                    ItemSectionHeaderHomeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), onSettingsClicked
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
                    )
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
        (holder as ViewHolderBinder<HomeSection>).bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
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