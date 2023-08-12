package com.geeks.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "b0955c7865msh9aa2d07834df51bp178160jsnfafc9e952806",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}