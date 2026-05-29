package com.techshrines.composefirstdemo.compose.model

import com.techshrines.composefirstdemo.compose.entity.ProductEntity

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: RatingDto
)

// Mapper Extensions
fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        title = this.title,
        price = this.price,
        description = this.description,
        category = this.category,
        imageUrl = this.image,
        ratingRate = this.rating.rate,
        ratingCount = this.rating.count
    )
}