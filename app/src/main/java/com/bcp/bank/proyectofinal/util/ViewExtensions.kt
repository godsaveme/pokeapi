package com.bcp.bank.proyectofinal.util


import android.graphics.drawable.GradientDrawable
import android.view.View



//region View

typealias ItemClickListener<T> = (position: Int, data: T) -> Unit
typealias ItemClickDialog<T> = (data: T) -> Unit

fun View.onClick(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}

//endregion



fun GradientDrawable.setCornerRadius(
    radius: Number,
    topLeftRadius: Number = 0f,
    topRightRadius: Number = 0f,
    bottomLeftRadius: Number = 0f,
    bottomRightRadius: Number = 0f
) {
    if (radius != 0f) {
        cornerRadius = radius.toFloat()
    } else {
        cornerRadii = floatArrayOf(
            topLeftRadius.toFloat(), topLeftRadius.toFloat(),
            topRightRadius.toFloat(), topRightRadius.toFloat(),
            bottomRightRadius.toFloat(), bottomRightRadius.toFloat(),
            bottomLeftRadius.toFloat(), bottomLeftRadius.toFloat()
        )
    }
}
