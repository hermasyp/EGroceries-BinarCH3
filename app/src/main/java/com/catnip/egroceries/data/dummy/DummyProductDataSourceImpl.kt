package com.catnip.egroceries.data.dummy

import com.catnip.egroceries.model.Product

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface DummyProductDataSource {
    fun getProductList(): List<Product>
}

class DummyProductDataSourceImpl() : DummyProductDataSource {
    override fun getProductList(): List<Product> = listOf(
        Product(
            id = 1,
            name = "Banana",
            price = 18000.0,
            weightInKg = 1.0,
            supplierName = "Banana Farm",
            rating = 4.8,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_banana.jpg"
        ),
        Product(
            id = 2,
            name = "Apple",
            price = 19000.0,
            weightInKg = 1.0,
            supplierName = "Apple Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_apple.jpg"
        ),
        Product(
            id = 3,
            name = "Onion",
            price = 12000.0,
            weightInKg = 1.0,
            supplierName = "Onion Farm",
            rating = 4.6,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_onion.jpg"
        ),
        Product(
            id = 4,
            name = "Spinach",
            price = 12000.0,
            weightInKg = 1.0,
            supplierName = "Spinach Farm",
            rating = 4.6,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_spinace.jpg"
        ),
        Product(
            id = 5,
            name = "Pineapple",
            price = 12000.0,
            weightInKg = 1.0,
            supplierName = "Pineapple Farm",
            rating = 4.7,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_pineapple.jpg"
        ),
        Product(
            id = 6,
            name = "Cabbage",
            price = 14000.0,
            weightInKg = 1.0,
            supplierName = "Cabbage Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_cabbage.jpg"
        ),
        Product(
            id = 7,
            name = "Carrot",
            price = 10000.0,
            weightInKg = 1.0,
            supplierName = "Carrot Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_carrot.jpg"
        ),
        Product(
            id = 8,
            name = "Potato",
            price = 11000.0,
            weightInKg = 1.0,
            supplierName = "Potato Farm",
            rating = 4.5,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_potato.jpg"
        ),
        Product(
            id = 9,
            name = "Lemon",
            price = 8000.0,
            weightInKg = 1.0,
            supplierName = "Lemon Farm",
            rating = 4.7,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_lemon.jpg"
        ),
        Product(
            id = 10,
            name = "Pumpkin",
            price = 21000.0,
            weightInKg = 1.0,
            supplierName = "Pumpkin Farm",
            rating = 4.7,
            desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac nisi eget libero ullamcorper varius a sed sem. Nam dictum purus ut mauris volutpat, in finibus elit consectetur. Nulla pulvinar tellus at libero volutpat sagittis. Praesent id feugiat dui. Pellentesque tincidunt, urna non consequat accumsan, lacus enim tristique orci, egestas aliquam neque lectus vel eros. Aliquam sed congue enim. Donec aliquam lorem eu velit tincidunt elementum. Nunc quis eleifend enim. Cras porttitor vulputate finibus. Donec fermentum tincidunt vulputate. Proin euismod nunc in orci tempor, eget rutrum est feugiat. Donec luctus, nibh ut congue dapibus, est purus commodo erat, quis ornare quam enim non justo.\n" +
                "\n" +
                "Praesent sed urna ac nisl sodales suscipit. Nulla non dictum sapien. Quisque commodo elit in nisi viverra, vehicula pellentesque justo aliquam. Quisque vel elit blandit, ullamcorper nibh vitae, mattis lacus. Quisque dolor odio, hendrerit et justo at, tristique facilisis dolor. Aliquam erat volutpat. Nulla consectetur quam id lacus tristique consequat. Suspendisse tincidunt mattis iaculis. Duis sed dignissim ipsum. Vestibulum eget sapien vel velit ullamcorper sollicitudin. In hac habitasse platea dictumst. Quisque congue arcu ut suscipit sollicitudin. Nullam gravida euismod purus, ut blandit sem ultricies non.\n" +
                "\n" +
                "Duis mattis dui venenatis massa condimentum lacinia. Proin ac risus sed urna mattis venenatis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Suspendisse aliquet hendrerit feugiat. Duis vitae urna lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque ornare varius neque lobortis interdum. Suspendisse ullamcorper gravida libero eget dapibus. Nam porttitor, lorem non scelerisque rhoncus, arcu neque mattis sapien, vel dignissim orci leo in risus. Nam eget tellus eget lectus porta rhoncus. Nam malesuada nisl vel dolor varius, ac dictum enim accumsan. Vivamus ut elit varius, dictum tortor laoreet, sodales augue. In interdum consectetur varius.",
            productImgUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/product_image/img_product_pumpkin.jpg"
        )
    )
}
