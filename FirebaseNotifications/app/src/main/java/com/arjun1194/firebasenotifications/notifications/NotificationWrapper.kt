package com.arjun1194.firebasenotifications.notifications

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.NotificationCompat
import com.arjun1194.firebasenotifications.MainActivity
import com.arjun1194.firebasenotifications.MyApplication
import com.arjun1194.firebasenotifications.R


class NotificationWrapper(private val context: Context) {

    companion object{
        const val acceptRequestCode = 10911
        const val declineRequestCode = 10899
//        var mediaPlayer: MediaPlayer  = MediaPlayer().apply {
//            setAudioAttributes(
//                AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_ALARM)
//                    .build()
//            )
//        };

    }

    private val notificationManager = context.getSystemService(NotificationManager::class.java)


    fun sendCallNotification(from: String){
        val intent = Intent(context, MainActivity::class.java)
        val acceptIntent = PendingIntent.getActivity(context, acceptRequestCode, intent, 0)
        val defaultRingtoneUri: Uri = RingtoneManager.getActualDefaultRingtoneUri(
            context,
            RingtoneManager.TYPE_RINGTONE
        )
        val notification = NotificationCompat.Builder(context, MyApplication.channelId).apply {
            setContentTitle(from)
            setContentText("Incoming Call...")
            setSmallIcon(R.drawable.ic_launcher_background)
            setOngoing(true)

            priority = NotificationCompat.PRIORITY_HIGH
            addAction(R.drawable.ic_accept, "Answer".toUpperCase(), acceptIntent)
            addAction(R.drawable.ic_reject, "Decline".toUpperCase(), acceptIntent)

        }.build();
//        mediaPlayer.apply {
//            setDataSource(context, defaultRingtoneUri)
//            prepare()
//            start()
//        }



        notificationManager.notify(acceptRequestCode, notification)
    }



    fun removeCurrentNotification(){
        notificationManager.cancel(acceptRequestCode)
    }
}