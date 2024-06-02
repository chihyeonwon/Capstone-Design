package com.example.giveback.LostBoard

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.giveback.Chatting.ChatActivity
import com.example.giveback.R
import com.example.giveback.databinding.ActivityLostBoardInsideBinding
import com.example.giveback.utils.FBAuth
import com.example.giveback.utils.FBRef
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

// 게시글 보기 페이지
class LostBoardInsideActivity : AppCompatActivity() {

    private val TAG = LostBoardInsideActivity::class.java.simpleName

    private lateinit var binding: ActivityLostBoardInsideBinding

    private lateinit var key:String

    private lateinit var writerEmail: String
    private lateinit var writerUid: String

    // 이미지 최대 개수
    var count = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_lost_board_inside)

        // boardSettingIcon을 클릭하면 custom_dialog layout이 나오도록 이벤트 처리
        binding.boardSettingIcon.setOnClickListener {
            showDialog()
        }


        key = intent.getStringExtra("key").toString()
        getBoardData(key)

        binding.manageNumber.text = "관리번호 : ${key}"

        writerEmail = intent.getStringExtra("email").toString()
        writerUid = intent.getStringExtra("uid").toString()

        binding.chatBtn.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("uid", writerUid)
            intent.putExtra("email", writerEmail)

            startActivity(intent)
        }

        getImageData(key, count)
    }

    // 만든 custom_dialog를 띄우는 showDialog() 함수 생성
    private fun showDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("게시글 수정/삭제")

        val alertDialog = mBuilder.show()
        // 수정버튼을 클릭했을 때
        alertDialog.findViewById<Button>(R.id.editBtn)?.setOnClickListener {
            Toast.makeText(this, "수정 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LostBoardEditActivity::class.java)
            intent.putExtra("key", key)
            startActivity(intent)

            alertDialog.dismiss()
        }
        // 삭제버튼을 클릭했을 때
        alertDialog.findViewById<Button>(R.id.removeBtn)?.setOnClickListener {

            val alertDialog = androidx.appcompat.app.AlertDialog.Builder(this)
                .setIcon(R.drawable.chat)
                .setTitle("해당 게시글을 삭제하겠습니까?")
                .setPositiveButton("확인") { dialog, which ->
                    FBRef.lostboardRef.child(key).removeValue()
                    Toast.makeText(this, "삭제완료", Toast.LENGTH_SHORT).show()

                    finish()
                }
                .setNegativeButton("취소", null)
                .create()
            alertDialog.show()
        }
    }
    // 이미지 데이터를 받아오는 함수
    private fun getImageData(key: String, count: Int) {

        // 사진을 차례대로 받아서 이미지뷰0~5번에 뿌림
        for (i in 0 until count) {

            val storageReference = Firebase.storage.reference.child("${key}${i}.png")

            val imageViewFromFB = findViewById<ImageView>(resources.getIdentifier("getImageArea$i", "id", packageName))

            storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUrl = task.result
                    if (imageViewFromFB != null) {
                        Glide.with(this)
                            .load(downloadUrl)
                            .into(imageViewFromFB)
                    }
                } else {
                    imageViewFromFB?.visibility = View.GONE
                }
            })

        }
    }

    // 게시글을 가져오는 함수
    private fun getBoardData(key: String) {
        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dataModel = dataSnapshot.getValue(LostBoardModel::class.java)

                if (dataModel != null) {

                    binding.emailArea.setText("분실자: ${dataModel.email}")
                    binding.titleArea.setText("분실물명: ${dataModel.title}")
                    binding.categoryArea.setText("카테고리명: ${dataModel.category}")
                    binding.lostDateArea.setText("분실날짜: ${dataModel.lostDate}")
                    binding.lostlocationArea.setText("분실위치: ${dataModel.lostLocation} ${dataModel.lostdetailLocation}")
                    binding.contentArea.setText("상세내용 : ${dataModel.content}")
                }

                val myUid = FBAuth.getUid()
                val writerUid = dataModel?.uid
                if(myUid.equals(writerUid)){
                    binding.boardSettingIcon.isVisible = true
                } else {

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.lostboardRef.child(key).addValueEventListener(postListner)
    }
}