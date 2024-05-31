package com.example.giveback.fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.giveback.LostBoard.LostBoardInsideActivity
import com.example.giveback.LostBoard.LostBoardListLVAdapter
import com.example.giveback.LostBoard.LostBoardModel
import com.example.giveback.R
import com.example.giveback.databinding.FragmentLostBinding
import com.example.giveback.searchLost.SearchLostActivity
import com.example.giveback.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

// 분실물 페이지
class LostFragment : Fragment() {

    private lateinit var binding: FragmentLostBinding

    private val boardDataList = mutableListOf<LostBoardModel>()
    private val boardKeyList = mutableListOf<String>()

    private lateinit var boardRVAdapter: LostBoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 파이어베이스 게시글 데이터 불러오기
        LostFBBoardData()

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lost, container, false)

        // BoardListLVAdpater와 연결
        boardRVAdapter = LostBoardListLVAdapter(boardDataList, boardKeyList)
        binding.boardListView.adapter = boardRVAdapter

        // 게시글 리스트 중 하나를 클릭했을 때
        binding.boardListView.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(context, LostBoardInsideActivity::class.java)
            intent.putExtra("key",boardKeyList[position])
            intent.putExtra("email", boardDataList[position].email)
            intent.putExtra("uid", boardDataList[position].uid)
            startActivity(intent)
        }

        // 돋보기 버튼을 눌렀을 때 검색 페이지(SearchLostActivity)로 이동
        binding.searchBtn.setOnClickListener {
            val intent = Intent(context, SearchLostActivity::class.java)
            startActivity(intent)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_LostFragment_to_bookmarkFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_LostFragment_to_homeFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_LostFragment_to_talkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_LostFragment_to_storeFragment)
        }

        return binding.root
    }

    // 게시글 데이터를 받아오는 함수
    private fun LostFBBoardData() {

        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear()

                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for(dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())

                    val item = dataModel.getValue(LostBoardModel::class.java)

                    boardDataList.add(item!!)
                    boardKeyList.add(dataModel.key.toString())
                }

                boardKeyList.reverse()
                // 최신 게시글이 앞으로 오도록 리스트를 뒤집는다.
                boardDataList.reverse()

                // boardRVAdapter 동기화
                boardRVAdapter.notifyDataSetChanged()

                Log.d(TAG, boardDataList.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.lostboardRef.addValueEventListener(postListner)
    }
}
