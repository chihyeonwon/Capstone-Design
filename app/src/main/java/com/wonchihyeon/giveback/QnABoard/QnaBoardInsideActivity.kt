package com.wonchihyeon.giveback.QnABoard

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.wonchihyeon.giveback.R
import com.wonchihyeon.giveback.comment.CommentLVAdpater
import com.wonchihyeon.giveback.comment.CommentModel
import com.wonchihyeon.giveback.databinding.ActivityQnaBoardInsideBinding
import com.wonchihyeon.giveback.utils.FBAuth
import com.wonchihyeon.giveback.utils.FBRef
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.wonchihyeon.giveback.utils.FcmPush
import com.wonchihyeon.giveback.utils.PreferenceUtil

// 게시글 보기 페이지
class QnaBoardInsideActivity : AppCompatActivity() {

    private val TAG = QnaBoardInsideActivity::class.java.simpleName

    private lateinit var binding: ActivityQnaBoardInsideBinding

    private lateinit var key: String

    private val commentDataList = mutableListOf<CommentModel>()

    private lateinit var commentAdapter: CommentLVAdpater

    val user = FirebaseAuth.getInstance().currentUser

    val email = user?.email.toString()

    private lateinit var writerUid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_board_inside)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_qna_board_inside)

        // 관리자일 경우에만 댓글 입력할 수 있는 창이 보이도록 수정
        if (email == "heungeob1003@gwnu.myplug.kr") {
            findViewById<LinearLayout>(R.id.writeComment).isVisible = true // 댓글 입력 레이아웃을 보이게 수정
        }

        // boardSettingIcon을 클릭하면 custom_dialog layout이 나오도록 이벤트 처리
        binding.boardSettingIcon.setOnClickListener {
            showDialog()
        }

        key = intent.getStringExtra("key").toString()

        getCommentData(key)

        writerUid = intent.getStringExtra("uid").toString()

        getBoardData(key)

        commentAdapter = CommentLVAdpater(commentDataList, key, writerUid)
        binding.commentLV.adapter = commentAdapter

        // 댓글 입력 버튼을 누르면 댓글을 데이터베이스에 넣는다.
        binding.commentBtn.setOnClickListener {
            insertComment(key)
        }
    }

    // 댓글 데이터를 받아오는 함수
    fun getCommentData(key: String) {
        val postListner = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                commentDataList.clear()

                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for (dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(CommentModel::class.java)
                    commentDataList.add(item!!)
                }
                commentAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.commentRef.child(key).addValueEventListener(postListner)

    }

    // 댓글 데이터를 데이터베이스에 입력하는 함수
    fun insertComment(key: String) {
        FBRef
            .commentRef
            .child(key)
            .push()
            .setValue(
                CommentModel(
                    binding.commentArea.text.toString(),
                    FBAuth.getTime()
                )
            )

        // 글 작성자에게 알림을 보낸다.
        FcmPush.instance.sendMessage(
            writerUid.toString(),
            "관리자님이 답변을 달았습니다.",
            "${binding.commentArea.text.toString()}"
        )

        // 댓글 입력 완료 토스트 메시지를 띄운다.
        Toast.makeText(this, "댓글 입력 완료", Toast.LENGTH_SHORT).show()
        // 댓글 입력 후에 입력창의 텍스트를 지운다.
        binding.commentArea.setText("")
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

            val intent = Intent(this, QnaBoardEditActivity::class.java)
            intent.putExtra("key", key)
            startActivity(intent)
        }
        // 삭제버튼을 클릭했을 때
        alertDialog.findViewById<Button>(R.id.removeBtn)?.setOnClickListener {
            FBRef.qnaboardRef.child(key).removeValue()
            Toast.makeText(this, "삭제완료", Toast.LENGTH_SHORT).show()

            finish()
        }
    }

    // 게시글 데이터를 가져오는 함수
    private fun getBoardData(key: String) {
        val postListner = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val dataModel = dataSnapshot.getValue(QnaBoardModel::class.java)
                if (dataModel != null) {
                    binding.titleArea.setText(dataModel.title)
                    binding.textArea.setText(dataModel.content)
                    writerUid = dataModel?.uid.toString()
                } else {
                    writerUid = "abc"
                }

                val myUid = FBAuth.getUid()
                val writerUid = dataModel?.uid
                if (myUid.equals(writerUid)) {
                    binding.boardSettingIcon.isVisible = true
                } else {

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.qnaboardRef.child(key).addValueEventListener(postListner)
    }
}