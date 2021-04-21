package com.bcp.bank.proyectofinal.util.style

import android.os.Build
import android.util.TypedValue
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.bcp.bank.proyectofinal.application.FinalApplication
import com.bcp.bank.proyectofinal.util.AppUtils


class TextViewBuilder(private var textView: TextView) {


    fun textInt(text: Int) = apply {
        val value = FinalApplication.resourses.getString(text)
        this.textView.text = value
    }

    fun textString(text: String) = apply {
        this.textView.text = text
    }

    fun textSize(size: Float) = apply {
        this.textView.textSize = size * AppUtils.getSizeFactor()
    }

    fun textAligment(gravity: Int) = apply {
        this.textView.gravity = gravity
    }


    fun textColor(color: Int) = apply {
        this.textView.setTextColor(
            ResourcesCompat.getColor(
                FinalApplication.resourses,
                color,
                null
            )
        )
    }

    fun setDynamicFont(minTextSize: Int, maxTextSize: Int) = apply {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.textView.setAutoSizeTextTypeUniformWithConfiguration(
                minTextSize,
                maxTextSize,
                2,
                TypedValue.COMPLEX_UNIT_SP
            )


        } else {
            TextViewBuilder(this.textView)
                .textSize(maxTextSize.toFloat())

        }
    }


}