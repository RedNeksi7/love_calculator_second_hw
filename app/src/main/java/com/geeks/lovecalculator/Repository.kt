package com.geeks.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geeks.lovecalculator.data.db.LoveDao
import com.geeks.lovecalculator.remote.LoveApi
import com.geeks.lovecalculator.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi, private val dao: LoveDao){

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("w", t.message.toString())
                }

            })
        return liveData
    }

    fun getAllData() = dao.getAll()

    fun getAllDataAlphabetically() = dao.getAllDataAlphabetically()

}