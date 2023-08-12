package com.geeks.lovecalculator.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.lovecalculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun LoveDao(): LoveDao
}