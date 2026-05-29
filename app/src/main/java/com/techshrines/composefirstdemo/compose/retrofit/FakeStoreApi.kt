package com.techshrines.composefirstdemo.compose.retrofit

import com.techshrines.composefirstdemo.compose.model.ProductDto
import retrofit2.http.GET

interface FakeStoreApi {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>
}