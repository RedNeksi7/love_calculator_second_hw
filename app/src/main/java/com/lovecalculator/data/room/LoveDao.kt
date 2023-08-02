package com.lovecalculator.data.room

import androidx.room.*
import com.lovecalculator.remote.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM love_table ORDER BY firstName ASC")
    fun getAllDataAlphabetically(): List<LoveModel>

    @Update
    fun update(loveModel: LoveModel)

    @Delete
    fun delete(loveModel: LoveModel)
}