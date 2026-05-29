package com.techshrines.composefirstdemo.compose.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techshrines.composefirstdemo.compose.entity.ProductEntity
import com.techshrines.composefirstdemo.compose.dao.ProductDao

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}