package com.bcp.bank.proyectofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.databinding.ActivityMainBinding
import com.bcp.bank.proyectofinal.util.style.ButtonBuilder
import com.bcp.bank.proyectofinal.util.style.TextViewBuilder

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)





        initializeUI()
        setup()


    }


    private fun initializeUI() {
        TextViewBuilder(binding.tviTitle)
            .textColor(R.color.colorGreenText)
            .textSize(24f)
            .textInt(R.string.lbl_welcome)



        TextViewBuilder(binding.tviDescription)
            .textColor(R.color.colorGrayText)
            .textSize(14f)


        ButtonBuilder(binding.butLogin)
            .background(R.color.colorGreenText, 16f)
            .textColor(R.color.colorWhite)
            .textSize(16f)

        ButtonBuilder(binding.butRegistrar)
            .background(R.color.colorWhite)
            .textColor(R.color.colorGreenText)
            .textSize(16f)

    }

    fun setup() {

        binding.butLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }
    }
}