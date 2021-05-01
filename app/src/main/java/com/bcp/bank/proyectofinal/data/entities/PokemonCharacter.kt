package com.bcp.bank.proyectofinal.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonCharacter (
    val id: Int,
    val name: String,
    //val front_default: String
    val sprites: Sprites,
) : Parcelable