package com.example.giveback.Chatting

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.giveback.R
import com.example.giveback.databinding.ActivityChatBinding
import com.example.giveback.utils.FcmPush
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

        binding.chatRecyclerView.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View?,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
                binding.chatRecyclerView.scrollToPosition(messageAdapter.itemCount - 1)
            }

        })

        //메시지 담을 변수
        var message: String = ""

        //버튼 비활성화
        binding.sendBtn.isVisible = false

        //EditText 값 있을때만 버튼 활성화
        binding.messageEdit.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            //값 변경 시 실행되는 함수
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                //입력값 담기
                message = binding.messageEdit.text.toString()

                //값 유무에 따른 활성화 여부
                binding.sendBtn.isVisible = message.isNotEmpty() //있다면 true 없으면 false
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

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

            FcmPush.instance.sendMessage(
                receiverUid.toString(),
                mAuth?.currentUser?.email + "님이 메시지를 보냈습니다",
                "$message"
            )
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
                    binding.chatRecyclerView.scrollToPosition(messageAdapter.itemCount - 1)
                }

                override fun onCancelled(error: DatabaseError) {

                }
            }
            )
    }
}
