package com.example.giveback.Chatting

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giveback.R
import com.example.giveback.WebviewActivity
import com.example.giveback.databinding.ActivityChatBinding
import com.example.giveback.utils.FcmPush
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    lateinit var mAuth: FirebaseAuth //인증 객체
    lateinit var mDbRef: DatabaseReference//DB 객체

    private lateinit var receiverRoom: String //받는 대화방
    private lateinit var senderRoom: String //보낸 대화방

    private lateinit var receiverUid: String
    private lateinit var receiverEmail: String

    private lateinit var messageAdapter: MessageAdapter
    var messageList: ArrayList<Message> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        messageAdapter = MessageAdapter(applicationContext, messageList)

        //RecyclerView
        binding.chatRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.chatRecyclerView.adapter = messageAdapter

        // GetBoardInsideActivity에서 넘어온 데이터를 변수에 담기
        receiverEmail = intent.getStringExtra("email").toString()
        receiverUid = intent.getStringExtra("uid").toString()

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        //액션바에 상대방 이름 보여주기
        getSupportActionBar()!!.setTitle("${receiverEmail}님과의 채팅")

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼 활성화
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.backicon)

        // 파이어베이스 인증, 데이터베이스 초기화
        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().reference

        //접속자 uId
        val senderUid = mAuth.currentUser?.uid

        val senderEmail = mAuth.currentUser?.email

        //보낸이방
        senderRoom = receiverUid + senderUid

        //받는이방
        receiverRoom = senderUid + receiverUid

        //메시지 전송 버튼 이벤트
        binding.sendBtn.setOnClickListener {

            //메세지 객체 생성
            val message = binding.messageEdit.text.toString()

            //메세지를 보낸 시간
            val time = System.currentTimeMillis()
            val dateFormat = SimpleDateFormat("MM월dd일 hh:mm")
            val curTime = dateFormat.format(Date(time)).toString()

            val messageObject = Message(message, senderUid, receiverUid, senderEmail, curTime)

            //데이터 저장
            mDbRef.child("chats").child(senderRoom).child("messages").push()
                .setValue(messageObject).addOnSuccessListener {
                    //저장 성공하면
                    mDbRef.child("chats").child(receiverRoom).child("messages").push()
                        .setValue(messageObject)

                }
            //입력값 초기화
            binding.messageEdit.setText("")
            binding.chatRecyclerView.scrollToPosition(messageAdapter.itemCount)
            messageAdapter.notifyDataSetChanged()
            
            FcmPush.instance.sendMessage(receiverUid.toString(), mAuth?.currentUser?.email+"님이 메시지를 보냈습니다", "$message")
        }

        getMessage()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                // 여기에 설정 아이템을 눌렀을 때의 동작을 추가하세요.
                return true
            }
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }

    //메시지 가져오기
    private fun getMessage() {
        mDbRef.child("chats").child(senderRoom).child("messages")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    messageList.clear()

                    for (postSnapshat in snapshot.children) {

                        val message = postSnapshat.getValue(Message::class.java)
                        messageList.add(message!!)
                    }
                    //적용
                    messageAdapter.notifyDataSetChanged()
                    binding.chatRecyclerView.scrollToPosition(messageAdapter.itemCount-1)
                }

                override fun onCancelled(error: DatabaseError) {

                }
            }
            )
    }
}