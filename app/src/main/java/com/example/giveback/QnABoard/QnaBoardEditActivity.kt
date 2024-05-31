package com.example.giveback.QnABoard

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.giveback.R
import com.example.giveback.databinding.ActivityQnaBoardEditBinding
import com.example.giveback.utils.FBAuth
import com.example.giveback.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

// 게시글 수정 페이지
class QnaBoardEditActivity : AppCompatActivity() {

    private lateinit var key:String

    private lateinit var binding: ActivityQnaBoardEditBinding

    private val TAG = QnaBoardEditActivity::class.java.simpleName

    private lateinit var writerUid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_qna_board_edit)

        key = intent.getStringExtra("key").toString()

        getBoardData(key)

        // 수정 버튼을 누르면 게시글과 이미지의 수정이 일어난다.
        binding.editBtn.setOnClickListener {
            editBoardData(key)
        }
    }

    // 게시글을 수정하는 함수
    private fun editBoardData(key: String) {
        FBRef.qnaboardRef
            .child(key) // 랜덤한 값
            .setValue(
                QnaBoardModel(binding.titleArea.text.toString(),
                    binding.contentArea.text.toString(),
                    writerUid,
                    FBAuth.getTime()))
        Toast.makeText(this,"수정완료", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    // 게시글을 가져오는 함수
    private fun getBoardData(key: String) {
        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dataModel = dataSnapshot.getValue(QnaBoardModel::class.java)

                if (dataModel != null) {
                    binding.titleArea.setText(dataModel.title)
                    binding.contentArea.setText(dataModel.content)
                    writerUid = dataModel.uid
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.qnaboardRef.child(key).addValueEventListener(postListner)
    }
}