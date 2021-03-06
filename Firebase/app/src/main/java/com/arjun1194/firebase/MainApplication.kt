package com.arjun1194.firebase

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
        Stetho.initializeWithDefaults(this);
    }
}