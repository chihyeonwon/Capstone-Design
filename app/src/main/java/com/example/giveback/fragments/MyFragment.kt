package com.example.giveback.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.giveback.Chatting.ChatListActivity
import com.example.giveback.Keyword.KeywordActivity
import com.example.giveback.MyBoard.MyBoardActivity
import com.example.giveback.R
import com.example.giveback.auth.LoginActivity
import com.example.giveback.databinding.FragmentMyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

// 사용자 페이지
class MyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentMyBinding

    private lateinit var auth: FirebaseAuth

    val user = FirebaseAuth.getInstance().currentUser
    val email = user?.email.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my, container, false)

        auth = FirebaseAuth.getInstance()

        binding.email.setText("사용자: ${email}")

        // 게시글 버튼을 클릭했을 때 내가 작성한 습득물, 분실물 게시판을 모아서 보여주는 Myboard 페이지로 이동
        binding.board.setOnClickListener {

            // MyboardActivity로 화면 이동
            val intent = Intent(context, MyBoardActivity::class.java)
            startActivity(intent)
        }

        // 키워드 옆 question버튼을 클릭했을 때 키워드 알림에 대한 도움말을 알려준다.
        binding.question.setOnClickListener {

            val alertDialog = AlertDialog.Builder(requireContext())
                .setIcon(R.drawable.chat)
                .setTitle("키워드 설정")
                .setMessage("사전에 물품을 설정하여 해당 물품과 관련된 게시글 등록 시 자동으로 알림을 받을 수 있는 기능입니다.")
                .setPositiveButton("확인") { dialog, which ->
                    dialog.dismiss()
                }
                .setNegativeButton("취소", null)
                .create()
            alertDialog.show()
        }

        // 키워드 버튼을 눌렀을 때 키워드 설정 페이지(SetKeywordActivitiy)로 이동
        binding.keyword.setOnClickListener {
            // SetkeywordActivity로 화면 이동
            val intent = Intent(requireContext(), KeywordActivity::class.java)
            startActivity(intent)
        }

        // chatting 버튼을 클릭했을 때 채팅방 리스트가 있는 (ChatListActivity)로 이동
        binding.chatting.setOnClickListener {
            // SetkeywordActivity로 화면 이동
            val intent = Intent(requireContext(), ChatListActivity::class.java)
            startActivity(intent)
        }
        
        // 로그아웃 버튼을 클릭했을 때 로그아웃이 진행되고 로그인 페이지로 이동
        binding.logoutBtn.setOnClickListener {

            val alertDialog = AlertDialog.Builder(requireContext())
                .setIcon(R.drawable.chat)
                .setTitle("로그아웃")
                .setMessage("계정을 로그아웃 합니다.")
                .setPositiveButton("확인") { dialog, which ->

                    val uid = FirebaseAuth.getInstance().currentUser?.uid

                    // 파이어베이스 토큰 삭제
                    FirebaseFirestore.getInstance().collection("pushtokens").document(uid!!).delete()

                    // 로그아웃
                    auth.signOut()

                    // LoginActivity로 화면 이동
                    val intent = Intent(context, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("취소", null)
                .create()
            alertDialog.show()
        }

        // SIGNOUT 버튼을 클릭했을 때 회원탈퇴가 진행되고 로그인 페이지로 이동
        binding.signoutBtn.setOnClickListener {

            val alertDialog = AlertDialog.Builder(requireContext())
                .setIcon(R.drawable.chat)
                .setTitle("회원탈퇴")
                .setMessage("회원탈퇴 시 모든 계정은 삭제되며 복구되지 않습니다.")
                .setPositiveButton("확인") { dialog, which ->
                    auth.currentUser?.delete()

                    // LoginActivity로 화면 이동
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("취소", null)
                .create()
            alertDialog.show()
        }


        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myFragment_to_tipFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myFragment_to_talkFragment)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myFragment_to_bookmarkFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_myFragment_to_homeFragment)
        }


        return binding.root
    }
}