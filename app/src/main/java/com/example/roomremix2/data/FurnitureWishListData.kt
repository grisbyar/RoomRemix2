package com.example.roomremix2.data

class FurnitureWishListData {
    //this will link google shopping to here and store wish list items
    data class Product(
        val title: String,
        val link: String,
        val imageLink: String,
        val price: String
    )

    data class WishlistItem(
        val title: String,
        val link: String,
        val imageLink: String,
        val floorplan: String,
    )
}