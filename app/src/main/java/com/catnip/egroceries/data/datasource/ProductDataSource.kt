package com.catnip.egroceries.data.datasource

import com.catnip.egroceries.model.Product

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface ProductDataSource {
    fun getProductList(): List<Product>
}

class ProductDataSourceImpl() : ProductDataSource {
    override fun getProductList(): List<Product> = listOf(
        Product(
            name = "Banana",
            price = 18000.0,
            weightInKg = 1.0,
            supplierName = "Banana Farm",
            rating = 4.8,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_banana.jpg"
        ),
        Product(
            name = "Apple",
            price = 19000.0,
            weightInKg = 1.0,
            supplierName = "Apple Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_apple.jpg"
        ),
        Product(
            name = "Onion",
            price = 12000.0,
            weightInKg = 1.0,
            supplierName = "Onion Farm",
            rating = 4.6,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_onion.jpg"
        ),
        Product(
            name = "Spinach",
            price = 12000.0,
            weightInKg = 1.0,
            supplierName = "Spinach Farm",
            rating = 4.6,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_spinace.jpg"
        ),
        Product(
            name = "Pineapple",
            price = 12000.0,
            weightInKg = 1.0,
            supplierName = "Pineapple Farm",
            rating = 4.7,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_pineapple.jpg"
        ),
        Product(
            name = "Cabbage",
            price = 14000.0,
            weightInKg = 1.0,
            supplierName = "Cabbage Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_cabbage.jpg"
        ),
        Product(
            name = "Carrot",
            price = 10000.0,
            weightInKg = 1.0,
            supplierName = "Carrot Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_carrot.jpg"
        ),
        Product(
            name = "Potato",
            price = 11000.0,
            weightInKg = 1.0,
            supplierName = "Potato Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_potato.jpg"
        ),
        Product(
            name = "Lemon",
            price = 8000.0,
            weightInKg = 1.0,
            supplierName = "Lemon Farm",
            rating = 4.7,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_lemon.jpg"
        ),
        Product(
            name = "Pumpkin",
            price = 21000.0,
            weightInKg = 1.0,
            supplierName = "Pumpkin Farm",
            rating = 4.7,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent in posuere dui. In hac habitasse platea dictumst. Morbi vitae tincidunt leo. Etiam id libero at turpis mollis posuere consectetur. ",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_pumpkin.jpg"
        ),
    )
}