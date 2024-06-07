package com.wonchihyeon.giveback.utils

import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

// 파이어베이스 계정관리와 관련된 클래스
class FBAuth {

    companion object {
        private lateinit var auth: FirebaseAuth

        // 현재 사용자의 UID를 가져오는 getUid 함수
        fun getUid() : String {

            auth = FirebaseAuth.getInstance()

            return auth.currentUser?.uid.toString()
        }

        // 현재 시간을 가져오는 getTime 함수
        fun getTime() : String {

            val currentDateTime = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA)
                .format(currentDateTime)

            return dateFormat
        }
    }
}