package com.techshrines.composefirstdemo.compose.repository

import com.techshrines.composefirstdemo.compose.entity.ProductEntity
import com.techshrines.composefirstdemo.compose.model.toEntity
import com.techshrines.composefirstdemo.compose.retrofit.FakeStoreApi
import com.techshrines.composefirstdemo.compose.dao.ProductDao
import kotlinx.coroutines.flow.Flow

class ProductRepository(
    private val dao: ProductDao,
    private val api: FakeStoreApi
) {
    // Expose local database streams to the UI
    fun getProducts(): Flow<List<ProductEntity>> = dao.getAllProducts()

    fun getProductById(id: Int): Flow<ProductEntity?> = dao.getProductById(id)

    // Synchronize network data down to the database
    suspend fun refreshProducts(): Result<Unit> {
        return try {
            val networkProducts = api.getProducts()
            val entities = networkProducts.map { it.toEntity() }
            dao.insertProducts(entities)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}