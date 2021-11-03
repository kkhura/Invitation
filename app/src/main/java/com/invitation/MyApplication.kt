package com.invitation

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.google.firebase.FirebaseApp

class MyApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
            FirebaseApp.initializeApp(this)
        try {
//            startService(Intent(this, SoundService::class.java))
        } catch (ex: Exception) {
        }
    }

    override fun onTerminate() {
//        stopService(Intent(this, SoundService::class.java))
        super.onTerminate()
    }
}