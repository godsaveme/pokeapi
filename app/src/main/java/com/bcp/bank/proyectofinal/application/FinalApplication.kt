package com.bcp.bank.proyectofinal.application

import android.app.Application
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FinalApplication : Application() {

    companion object {


        lateinit var resourses: Resources
            private set
    }

    override fun onCreate() {
        super.onCreate()

        resourses = resources

    }


}
