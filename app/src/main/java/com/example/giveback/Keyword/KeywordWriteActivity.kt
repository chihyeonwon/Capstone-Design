package com.example.giveback.Keyword

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.giveback.GetBoard.GetBoardModel
import com.example.giveback.QnABoard.KeywordStatusModel
import com.example.giveback.R
import com.example.giveback.databinding.ActivityKeywordWriteBinding
import com.example.giveback.utils.FBAuth
import com.example.giveback.utils.FBRef
import com.example.giveback.utils.FcmPush
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class KeywordWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeywordWriteBinding

    private val PERMISSION_REQUEST_CODE = 5000

    var auth = FirebaseAuth.getInstance()

    var myUid = auth.currentUser?.uid.toString()

    var keywordList = mutableListOf<String>()

    var uid = FBAuth.getUid()

    private lateinit var dialog: Dialog

    private lateinit var category: String

    private lateinit var keyword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_keyword_write)

        // 카테고리를 선택해주세요 버튼을 눌렀을 때 카테고리 설정 창으로 이동한다.
        binding.keywordArea.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.category_item, null)
            val mBuilder = android.app.AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("카테고리 설정창")

            val alertDialog = mBuilder.show()

            // 지갑을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.wallet)?.setOnClickListener {
                Toast.makeText(this, "지갑 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.wallet).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 카드을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.card)?.setOnClickListener {
                Toast.makeText(this, "카드 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.card).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 현금을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.cash)?.setOnClickListener {
                Toast.makeText(this, "현금 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.cash).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 가방을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.bag)?.setOnClickListener {
                Toast.makeText(this, "가방 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.bag).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 전자기기을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.device)?.setOnClickListener {
                Toast.makeText(this, "전자기기 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.device).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 의류을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.cloth)?.setOnClickListener {
                Toast.makeText(this, "의류 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.cloth).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 스포츠을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.sport)?.setOnClickListener {
                Toast.makeText(this, "스포츠 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.sport).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 자동차을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.car)?.setOnClickListener {
                Toast.makeText(this, "자동차 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.car).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 서류를 클릭했을 때
            alertDialog.findViewById<Button>(R.id.document)?.setOnClickListener {
                Toast.makeText(this, "서류 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.document).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 악기을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.instrument)?.setOnClickListener {
                Toast.makeText(this, "악기 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.instrument).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 증명서을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.certification)?.setOnClickListener {
                Toast.makeText(this, "증명서 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.certification).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }

            // 기타을 클릭했을 때
            alertDialog.findViewById<Button>(R.id.etc)?.setOnClickListener {
                Toast.makeText(this, "기타 카테고리를 눌렀습니다.", Toast.LENGTH_SHORT).show()

                category =  alertDialog.findViewById<Button>(R.id.etc).text.toString()
                binding.keywordArea.setText(category)

                alertDialog.dismiss()
            }
        }

        binding.settingBtn.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this)
                .setIcon(R.drawable.chat)
                .setTitle("${binding.keywordArea.text.toString()}을 키워드로 등록합니다.")
                .setMessage("등록된 키워드로 습득물 게시글이 올라올 시 알림이 발생합니다.")
                .setPositiveButton("확인") { dialog, which ->

                    keyword = binding.keywordArea.text.toString()

                    // 키부터 생성하고 데이터베이스에 저장하도록 수정
                    val key = FBRef.getboardRef.push().key.toString()

                    // 파이어 베이스에 데이터를 저장한다.
                    FBRef.keywordRef
                        .child(key) // 랜덤한 값
                        .setValue(
                            KeywordStatusModel(
                                uid,
                                keyword.toString()
                            )
                        )
                    getKeyword()

                    finish()
                }
                .setNegativeButton("취소", null)
                .create()
            alertDialog.show()
        }
    }

    private fun getKeyword() {
        // ChildEventListener 등록
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                // 글이 추가되었을 때 처리하는 로직
                val post = snapshot.getValue(GetBoardModel::class.java)
                // 코루틴을 시작하여 백그라운드에서 실행
                GlobalScope.launch {
                    if(post?.category.equals(findViewById<TextView>(R.id.keywordArea).text.toString())) {
                        FcmPush.instance.sendMessage(
                            auth?.currentUser?.uid.toString(),
                            "등록된 ${keyword}으로 습득물 게시글이 올라왔습니다.",
                            "앱을 실행하여 분실물을 확인하세요")
                    }
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // 글이 변경되었을 때 처리하는 로직
                val post = snapshot.getValue(GetBoardModel::class.java)
                val post2 = snapshot.getValue(KeywordStatusModel::class.java)
                // 코루틴을 시작하여 백그라운드에서 실행

            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                // 글이 삭제되었을 때 처리하는 로직
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // 글의 순서가 변경되었을 때 처리하는 로직
            }

            override fun onCancelled(error: DatabaseError) {
                // 에러 처리
            }
        }

        // posts 경로에 ChildEventListener 등록
        FBRef.getboardRef.addChildEventListener(childEventListener)
    }

    private fun permissionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionCheck = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    PERMISSION_REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(applicationContext, "Permission is denied", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(applicationContext, "Permission is granted", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}