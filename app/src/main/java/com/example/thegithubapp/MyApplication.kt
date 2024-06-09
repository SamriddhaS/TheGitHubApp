package com.example.thegithubapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApplication : Application() {

    //Initialise timeber debug tree
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}