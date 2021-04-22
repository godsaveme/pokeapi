package com.bcp.bank.proyectofinal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DashboardResponse(
    val employee: String,
    val vacation: String
) : Parcelable