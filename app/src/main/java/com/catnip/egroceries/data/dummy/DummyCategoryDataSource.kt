package com.catnip.egroceries.data.dummy

import com.catnip.egroceries.model.Category

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface DummyCategoryDataSource {
    fun getProductCategory(): List<Category>
}

class DummyCategoryDataSourceImpl() : DummyCategoryDataSource {
    override fun getProductCategory(): List<Category> =
        listOf(
            Category(
                name = "All",
                slug = "all",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_all_category.png"
            ),
            Category(
                name = "Groceries",
                slug = "groceries",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_groceries.png"
            ),
            Category(
                name = "Fruits",
                slug = "fruits",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_fruits.png"
            ),
            Category(
                name = "Spices",
                slug = "spices",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_spices.png"
            ),
            Category(
                name = "Herbs",
                slug = "herbs",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_herbs.png"
            ),
            Category(
                name = "Seasoning",
                slug = "seasoning",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_seasoning.png"
            ),
            Category(
                name = "Meat",
                slug = "meat",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_meat.png"
            ),
            Category(
                name = "Beer",
                slug = "beer",
                categoryImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_beer.png"
            )
        )
}
