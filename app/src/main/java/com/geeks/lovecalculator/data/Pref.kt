package com.geeks.lovecalculator.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(context: Context) {
    private var pref: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isUserSeen(): Boolean {
        return pref.getBoolean(ON_BOARDING_KEY, false)
    }

    fun saveSeen() {
        pref.edit().putBoolean(ON_BOARDING_KEY, true).apply()
    }

    companion object {
        const val PREF_NAME = "LoveCalculator_Pref"
        const val ON_BOARDING_KEY = "OnBoarding_Key"
    }
}