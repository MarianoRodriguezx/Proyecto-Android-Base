package com.mariano.projectobase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appSingleton = this
    }

    companion object {

        lateinit var appSingleton: App

        fun getInstance(): App{
            return appSingleton
        }
    }
}