package com.arjun1194.firebasenotifications

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.google.firebase.messaging.FirebaseMessaging

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()



        Firebase.initialize(this)
        getToken()
        createNotificationChannel()

    }

    private fun createNotificationChannel(){
        val channel = NotificationChannel(channelId, channelDesc, NotificationManager.IMPORTANCE_HIGH)
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    private fun getToken(){
        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            println("Token is ---> $it")
        }
    }

    companion object{
        const val channelId = "CALL_NOTIFICATION"
        const val channelDesc = "Notifications related to calls"
    }
}