package com.example.giveback.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessageService : FirebaseMessagingService() {

    // 매개변수값이 토큰
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("토큰", "fcm token.... $token")
    }

    // 매개변수 객체의 data프로퍼티로 메시지를 얻음
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("메시지 값", "fcm message... ${message.data}")
    }

}