package com.bcp.bank.proyectofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.databinding.ActivityPokeApiBinding
import com.bcp.bank.proyectofinal.util.style.ButtonBuilder
import com.bcp.bank.proyectofinal.util.style.TextViewBuilder

class PokeApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokeApiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeUI()
        setup()
    }

    private fun initializeUI(){
        TextViewBuilder(binding.txtWelcome)
            .textColor(R.color.pokeApiMain)
            .textSize(40f)
            .textInt(R.string.lbl_welcome)



        TextViewBuilder(binding.txtSecond)
            .textColor(R.color.pokeApiSecond)
            .textInt(R.string.pokeApi_second)
            .textSize(18f)


        ButtonBuilder(binding.btnStart)
            .background(R.color.pokeApiMain, 16f)
            .textColor(R.color.colorWhite)
            .textInt(R.string.pokeApi_btn_start)
            .textSize(16f)


    }

    private fun setup() {

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}