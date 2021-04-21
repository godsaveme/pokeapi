package com.bcp.bank.proyectofinal.util


import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import com.bcp.bank.proyectofinal.application.FinalApplication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AppUtils {
    companion object {

        inline fun <reified T> fromJson(json: String): T {
            return Gson().fromJson(json, object : TypeToken<T>() {}.type)
        }


        fun dpToPx(dp: Int): Int {
            return ((dp * Resources.getSystem().displayMetrics.density).toInt());
        }

        fun pxToDp(px: Int, context: Context): Int {
            return ((px / Resources.getSystem().displayMetrics.density).toInt());
        }

        open class EnumCompanion<T, V>(private val valueMap: Map<T, V>) {
            fun fromValue(type: T) = valueMap[type]
        }


        fun getSizeFactor(): Float {
            val density: Float
            when (FinalApplication.resourses.displayMetrics.densityDpi) {

                DisplayMetrics.DENSITY_LOW -> density = 0.7f
                DisplayMetrics.DENSITY_140 -> density = 0.7f

                DisplayMetrics.DENSITY_MEDIUM -> density = 0.8f
                DisplayMetrics.DENSITY_180, DisplayMetrics.DENSITY_200, DisplayMetrics.DENSITY_220 -> density =
                    0.8f

                DisplayMetrics.DENSITY_HIGH -> density = 0.9f
                DisplayMetrics.DENSITY_260, DisplayMetrics.DENSITY_280, DisplayMetrics.DENSITY_300 -> density =
                    0.9f

                in DisplayMetrics.DENSITY_XHIGH..DisplayMetrics.DENSITY_440 -> density = 0.95f

                DisplayMetrics.DENSITY_XXHIGH -> density = 1f
                DisplayMetrics.DENSITY_560, DisplayMetrics.DENSITY_600 -> density = 0.9f

                DisplayMetrics.DENSITY_XXXHIGH -> density = 1.01f
                DisplayMetrics.DENSITY_TV -> density = 1.01f
                else -> density = 1f
            }

            return density
        }


    }


}
