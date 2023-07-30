package com.geeks.lovecalculator.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoveModel(
    @SerializedName("fname") var first_name: String,
    @SerializedName("sname") var second_name: String,
    var percentage: String,
    var result: String,
) : Serializable