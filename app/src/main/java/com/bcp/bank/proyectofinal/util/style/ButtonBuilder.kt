package com.bcp.bank.proyectofinal.util.style

import android.graphics.drawable.GradientDrawable
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.bcp.bank.proyectofinal.application.FinalApplication
import com.bcp.bank.proyectofinal.util.AppUtils
import com.bcp.bank.proyectofinal.util.setCornerRadius


class ButtonBuilder(private var button: Button) {


    fun textInt(text: Int) = apply {
        val value = FinalApplication.resourses.getString(text)
        this.button.text = value
    }

    fun textString(text: String) = apply {
        this.button.text = text
    }

    fun textSize(size: Float) = apply {
        this.button.textSize = size * AppUtils.getSizeFactor()
    }

    fun textColor(color: Int) = apply {
        this.button.setTextColor(
            ResourcesCompat.getColor(
                FinalApplication.resourses,
                color,
                null
            )
        )
    }

    fun border(size: Int, color: Int) = apply {
        val shape = GradientDrawable()
        shape.setCornerRadius(16f, 0, 0, 0, 0)
        //shape.setColor(ResourcesCompat.getColor(EZFormsApplication.resourses, color, null))
        shape.setStroke(
            size, ResourcesCompat.getColor(
                FinalApplication.resourses,
                color,
                null
            )
        )

        this.button.background = shape
    }


    fun background(color: Int, radius: Float = 0f) = apply {

        if (radius == 0f) {
            this.button.background = ContextCompat.getDrawable(button.context, color)
        } else {
            //Setup cornerRadius
            val shape = GradientDrawable()

            shape.setCornerRadius(radius, 0, 0, 0, 0)
            shape.setColor(ResourcesCompat.getColor(FinalApplication.resourses, color, null))
            this.button.background = shape
        }

    }


}