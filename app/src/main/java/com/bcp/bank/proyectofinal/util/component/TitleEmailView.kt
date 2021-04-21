package com.bcp.bank.proyectofinal.util.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater

import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.bcp.bank.proyectofinal.R
import com.bcp.bank.proyectofinal.databinding.ViewTitleEdittextBinding
import com.bcp.bank.proyectofinal.databinding.ViewTitleEmailBinding


class TitleEmailView(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {


    private var binding: ViewTitleEmailBinding = ViewTitleEmailBinding.inflate(
        LayoutInflater
            .from(context), this, true
    )


    init {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TitleEmailView)
        binding.tviTitle.text = attributes.getString(R.styleable.TitleEmailView_title)


        attributes.recycle()


    }


    fun initializeUI(title: String) {


        binding.tviTitle.text = title

    }


}