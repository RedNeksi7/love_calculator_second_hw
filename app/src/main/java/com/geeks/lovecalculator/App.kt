package com.geeks.lovecalculator

import android.app.Application
import androidx.room.Room
import com.geeks.lovecalculator.data.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Love-file")
            .allowMainThreadQueries().build()
    }
}