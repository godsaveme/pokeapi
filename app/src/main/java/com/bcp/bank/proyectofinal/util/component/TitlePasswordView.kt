package com.bcp.bank.proyectofinal.util.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater

import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.databinding.ViewTitleEdittextBinding
import com.bcp.bank.proyectofinal.databinding.ViewTitleEmailBinding
import com.bcp.bank.proyectofinal.databinding.ViewTitlePasswordBinding


class TitlePasswordView(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {


    private var binding: ViewTitlePasswordBinding = ViewTitlePasswordBinding.inflate(
        LayoutInflater
            .from(context), this, true
    )


    init {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TitlePasswordView)
        binding.tviTitle.text = attributes.getString(R.styleable.TitlePasswordView_title)


        attributes.recycle()


    }


    fun initializeUI(title: String) {


        binding.tviTitle.text = title

    }


}