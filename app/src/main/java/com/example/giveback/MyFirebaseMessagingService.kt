package com.example.giveback

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.net.URLDecoder


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d("FCMLog", "Refreshed token: " + token);
        // 보통은 기기에 저장...코드 작성
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {

        // notification
        if(message.notification != null) { //포그라운드
            sendNotification(message.notification?.title!!, message.notification?.body!!);
        }

        // data
        if (message.data.isNotEmpty()) { //백그라운드
            message.data["title"]?.let { sendNotification(it, message.data["body"]!!) };
        }
    }

    // FCM 푸시 메시지를 앱에서 알림
    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendNotification(title: String, body: String) {

        Log.d("FCMLog", "호출")
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
        val chId = "myChId"
        val chName = "myChName"
        val soundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notiBuilder: NotificationCompat.Builder = NotificationCompat.Builder(this, chId)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(title)
            .setContentText(body)
            .setContentTitle(URLDecoder.decode(title, "UTF-8"))
            .setContentText(URLDecoder.decode(body, "UTF-8"))
            .setAutoCancel(true)
            .setSound(soundUri)
            .setContentIntent(pendingIntent)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(chId, chName, NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)
        manager.notify((System.currentTimeMillis()).toInt(), notiBuilder.build())
    }

}