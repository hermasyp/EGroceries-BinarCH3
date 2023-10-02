package com.catnip.egroceries.data.dummy

import com.catnip.egroceries.model.Category

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface CategoryDataSource {
    fun getProductCategory(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getProductCategory(): List<Category> =
        listOf(
            Category(
                name = "Groceries",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_groceries.png"
            ),
            Category(
                name = "Fruits",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_fruits.png"
            ),
            Category(
                name = "Spices",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_spices.png"
            ),
            Category(
                name = "Herbs",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_herbs.png"
            ),
            Category(
                name = "Seasoning",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_seasoning.png"
            ),
            Category(
                name = "Meat",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_meat.png"
            ),
        )
}