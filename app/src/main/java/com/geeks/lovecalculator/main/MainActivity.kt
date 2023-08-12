package com.geeks.lovecalculator.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.geeks.lovecalculator.R
import com.geeks.lovecalculator.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun initView() {
        with(binding){
            ivHeart.setOnClickListener{
                navController.navigate(R.id.navigate_mainFragment)
            }
            ivHistory.setOnClickListener{
                navController.navigate(R.id.navigate_historyFragment)
            }
        }
    }
}