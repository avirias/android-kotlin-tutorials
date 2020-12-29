package com.arjun1194.firebasenotifications.messaging

import android.content.Intent
import com.arjun1194.firebasenotifications.notifications.NotificationWrapper
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFirebaseService: FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        println("Remote message is ---> ${p0.data}")
        FirebaseData().uploadLog("Remote message is ---> ${p0.data}")
        NotificationWrapper(this).sendCallNotification(p0.data["caller"].toString())

    }

    override fun handleIntentOnMainThread(p0: Intent?): Boolean {
        return super.handleIntentOnMainThread(p0)

    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }
}