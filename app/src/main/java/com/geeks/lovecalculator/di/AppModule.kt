package com.geeks.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.geeks.lovecalculator.data.Pref
import com.geeks.lovecalculator.data.db.AppDatabase
import com.geeks.lovecalculator.data.db.LoveDao
import com.geeks.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, "Love-file")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun provideLove(@ApplicationContext context: Context): LoveDao{
        return provideAppDatabase(context).LoveDao()
    }

    @Singleton
    @Provides
    fun providePref(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }
}