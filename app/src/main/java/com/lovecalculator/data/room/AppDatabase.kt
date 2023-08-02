package com.lovecalculator.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lovecalculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun LoveDao(): LoveDao
}