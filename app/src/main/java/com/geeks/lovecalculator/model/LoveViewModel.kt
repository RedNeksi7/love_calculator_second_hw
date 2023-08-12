package com.geeks.lovecalculator.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.lovecalculator.Repository
import com.geeks.lovecalculator.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel(), java.io.Serializable {

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }

    fun getAll(): MutableLiveData<List<LoveModel>> = MutableLiveData(repository.getAllData())

    fun getAllAlphabetically(): MutableLiveData<List<LoveModel>> = MutableLiveData(repository.getAllDataAlphabetically())
}