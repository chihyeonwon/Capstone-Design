package com.example.giveback.QnABoard

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.giveback.R
import com.example.giveback.databinding.ActivityQnaBoardWriteBinding
import com.example.giveback.utils.FBAuth
import com.example.giveback.utils.FBRef
import com.google.firebase.auth.FirebaseAuth

// QnA 게시글 작성 페이지
class QnaBoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityQnaBoardWriteBinding

    var auth = FirebaseAuth.getInstance()

    var email = auth.currentUser?.email

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_qna_board_write)

        // 게시글 작성 버튼을 눌렀을 때 파이어베이스에 게시글과 이미지를 넣는다.
        binding.writeBtn.setOnClickListener {

            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()

            // uid를 가져온다.
            val uid = FBAuth.getUid()

            // 키부터 생성하고 데이터베이스에 저장하도록 수정
            val key = FBRef.qnaboardRef.push().key.toString()

            // 파이어 베이스에 데이터를 저장한다.
            FBRef.qnaboardRef
                .child(key) // 랜덤한 값
                .setValue(QnaBoardModel(uid, email.toString(),title,content, "대기"))

            Toast.makeText(this,"게시글 입력 완료", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}