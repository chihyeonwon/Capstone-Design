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
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giveback.R
import com.example.giveback.databinding.ActivityChatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        //액션바에 상대방 이름 보여주기
        binding.topBar.text = "습득자: ${receiverEmail}님과의 채팅방입니다."

        // 파이어베이스 인증, 데이터베이스 초기화
        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().reference

        //접속자 uId
        val senderUid = mAuth.currentUser?.uid

        //보낸이방
        senderRoom = receiverUid + senderUid

        //받는이방
        receiverRoom = senderUid + receiverUid


        createNotificationChannel()

        getKeyword()


        //메시지 전송 버튼 이벤트
        binding.sendBtn.setOnClickListener {

            val message = binding.messageEdit.text.toString()
            val messageObject = Message(message, senderUid, receiverUid)

            //데이터 저장
            mDbRef.child("chats").child(senderRoom).child("messages").push()
                .setValue(messageObject).addOnSuccessListener {
                    //저장 성공하면
                    mDbRef.child("chats").child(receiverRoom).child("messages").push()
                        .setValue(messageObject)

                }
            //입력값 초기화
            binding.messageEdit.setText("")
        }

        getMessage()
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
                }

                override fun onCancelled(error: DatabaseError) {

                }
            }
            )
    }

    private fun getKeyword() {
        // ChildEventListener 등록
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                // 글이 추가되었을 때 처리하는 로직
                val post = snapshot.getValue(Message::class.java)
                // 코루틴을 시작하여 백그라운드에서 실행
                GlobalScope.launch {
                    if (post?.receiveId?.toString().equals(mAuth.currentUser?.uid.toString())) {
                        sendNotification()
                    }
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // 글이 변경되었을 때 처리하는 로직
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
        mDbRef.child("chats").child(receiverRoom).child("messages")
            .addChildEventListener(childEventListener)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "TestChannel"
            val descriptionText = "Your channel description here"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(name, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification() {

        val intent = Intent(this, ChatActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this@ChatActivity,
            (System.currentTimeMillis()).toInt(),
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(this, "TestChannel")
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle("누군가가 채팅을 시작했습니다.")
            .setContentText("앱을 실행하여 채팅을 시작하세요")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        // Display the notification
        with(NotificationManagerCompat.from(this)) {
            notify((System.currentTimeMillis()).toInt(), builder.build())
        }
    }
}