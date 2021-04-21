package com.bcp.bank.proyectofinal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcp.bank.proyectofinal.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}