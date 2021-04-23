package com.bcp.bank.proyectofinal.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.databinding.ActivityNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity : AppCompatActivity() {


    private lateinit var binding: ActivityNavigationBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //Configuracion Navigation Bottom

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragNavHost) as NavHostFragment

        NavigationUI.setupWithNavController(binding.bottomNavView, navHostFragment.navController)


        navController = navHostFragment.navController


    }
}