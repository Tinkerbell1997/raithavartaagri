package com.example.raithavarta.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.raithavarta.dao.TipDao
import com.example.raithavarta.model.TipEntity

@Database(
    entities = [TipEntity::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun tipDao(): TipDao
}