package com.example.giveback.utils

import com.example.giveback.Chatting.Message
import com.example.giveback.PushDTO
import com.google.common.net.MediaType
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException
import org.json.JSONObject

// 푸시를 전송해주는 클래스
class FcmPush {

    // 헤더값
    val JSON = MediaType.parse("application/json; charset=utf-8")

    // 푸시를 보낼 값 (Firebase 공식문서의 Legacy HTTP Server Protocol 주소)
    val url = "https://fcm.googleapis.com/fcm/send"

    val serverKey = "AAAA1l3beaI:APA91bGyEnn6KtvnUzoFr-Nwx18oRd0CSl1SwVGhr1YISMVBfdgwqA37d-2DB8EQykA44rpNbSgKiwURNB74XEstviIOpcTGwqIjESseBSPpMrYNv2TlDY4b-0eMt7XBf7iJYVhoLuuM"

    var gson: Gson? = null

    var okHttpClient: OkHttpClient? = null

    // 싱글톤 패턴으로 어디에서나 사용가능하게 선언
    companion object {
        val instance = FcmPush()
    }

    init {
        // gson, okhttp 초기화
        gson = Gson()
        okHttpClient = OkHttpClient()
    }

    fun sendMessage(destinationUid: String, title: String, message: String) {
        FirebaseDatabase.getInstance().getReference("pushtokens").child(destinationUid).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task?.result.toString()

                val pushDTO = PushDTO()
                pushDTO.to = token
                pushDTO.notification.title = title
                pushDTO.notification.body = message

                val jsonObject = JSONObject()

                val body = jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
                val request = Request.Builder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "key="+serverKey) // OAuth2 토큰 추가
                    .url(url)
                    .post(body)
                    .build()

                okHttpClient?.newCall(request)?.enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        // 실패 처리
                    }

                    override fun onResponse(call: Call, response: Response) {
                        println(response.body?.string())
                    }
                })
            }
        }
    }
}