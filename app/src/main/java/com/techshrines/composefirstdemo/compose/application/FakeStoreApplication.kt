package com.techshrines.composefirstdemo.compose.application

import android.app.Application
import androidx.room.Room
import com.techshrines.composefirstdemo.compose.repository.ProductRepository
import com.techshrines.composefirstdemo.compose.retrofit.RetrofitClient
import com.techshrines.composefirstdemo.compose.room.AppDatabase

class FakeStoreApplication : Application() {

    // Define dependencies as lazy properties so they initialize only when needed
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "fake_store_products.db"
        ).build()
    }

    val repository: ProductRepository by lazy {
        ProductRepository(
            dao = database.productDao(),
            api = RetrofitClient.api
        )
    }
}