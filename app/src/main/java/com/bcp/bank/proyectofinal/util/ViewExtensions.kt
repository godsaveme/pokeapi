package com.bcp.bank.proyectofinal.util


import android.view.View



//region View

typealias ItemClickListener<T> = (position: Int, data: T) -> Unit
typealias ItemClickDialog<T> = (data: T) -> Unit

fun View.onClick(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}

//endregion

