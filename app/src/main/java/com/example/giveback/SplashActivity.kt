package com.example.giveback

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.giveback.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth

// 앱을 실행했을 때 3초간 실행되게 할 스플래쉬 페이지
class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 현재 로그인한 유저가 없다면 3초 이후에 인트로페이지로 이동시킨다.
        if(auth.currentUser?.uid == null) {
            Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }, 3000)
        } else { // 로그인되어 있다면 3초 이후에 메인페이지로 이동시킨다.
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)
        }
    }
}