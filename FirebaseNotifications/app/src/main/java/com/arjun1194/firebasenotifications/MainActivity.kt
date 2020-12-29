package com.arjun1194.firebasenotifications

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.arjun1194.firebasenotifications.notifications.NotificationWrapper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById<Button>(R.id.btn)

        // remove this later
        val notificationWrapper = NotificationWrapper(this).run {
            removeCurrentNotification()
            //NotificationWrapper.mediaPlayer.release();
        }

        // stop playing sound
        button.setOnClickListener {
            //mediaPlayer.start()
        }
    }


}