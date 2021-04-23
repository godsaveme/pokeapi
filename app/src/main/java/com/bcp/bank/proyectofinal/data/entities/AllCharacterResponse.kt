package com.bcp.bank.proyectofinal.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllCharacterResponse(

    val results: List<RMCharacter>
) : Parcelable