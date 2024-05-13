package com.example.giveback.utils

import com.example.giveback.Chatting.Message
import com.example.giveback.PushDTO
import com.google.common.net.MediaType
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.getValue
import com.google.firebase.firestore.FirebaseFirestore
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
class FcmPush() {
    val JSON = MediaType.parse("application/json; charset=utf-8")
    val url = "https://fcm.googleapis.com/fcm/send"
    val serverKey = "AAAA1l3beaI:APA91bGyEnn6KtvnUzoFr-Nwx18oRd0CSl1SwVGhr1YISMVBfdgwqA37d-2DB8EQykA44rpNbSgKiwURNB74XEstviIOpcTGwqIjESseBSPpMrYNv2TlDY4b-0eMt7XBf7iJYVhoLuuM"

    var okHttpClient: OkHttpClient? = null
    var gson: Gson? = null
    init {
        gson = Gson()
        okHttpClient = OkHttpClient()
    }

    // 싱글톤 패턴으로 어디에서나 사용가능하게 선언
    companion object {
        val instance = FcmPush()
    }

    fun sendMessage(destinationUid: String, title: String, message: String) {
        FirebaseFirestore.getInstance().collection("pushtokens").document(destinationUid).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                var token = task?.result?.get("pushToken").toString()

                var pushDTO = PushDTO()
                pushDTO.to = token
                pushDTO.notification.title = title
                pushDTO.notification.body = message

                val jsonObject = gson?.toJson(pushDTO)

                val body = jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaType())
                var request = Request
                    .Builder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "key=" + serverKey)
                    .url(url)
                    .post(body)
                    .build()

                okHttpClient?.newCall(request)?.enqueue(object : Callback {

                    override fun onFailure(call: Call, e: IOException) {

                    }

                    override fun onResponse(call: Call, response: Response) {
                        println(response?.body?.string())
                    }
                })
            }
        }
    }
}