package com.wonchihyeon.giveback.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.wonchihyeon.giveback.GetBoard.GetBoardInsideActivity
import com.wonchihyeon.giveback.GetBoard.GetBoardListLVAdapter
import com.wonchihyeon.giveback.GetBoard.GetBoardModel
import com.wonchihyeon.giveback.R
import com.wonchihyeon.giveback.databinding.FragmentGetBinding
import com.wonchihyeon.giveback.searchGet.SearchGetActivity
import com.wonchihyeon.giveback.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Calendar

// 습득물 페이지
class GetFragment : Fragment() {

    private lateinit var binding: FragmentGetBinding

    private val boardDataList = mutableListOf<GetBoardModel>()
    private val boardKeyList = mutableListOf<String>()

    private lateinit var boardRVAdapter: GetBoardListLVAdapter

    private val TAG = GetFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 파이어베이스 게시글 데이터 불러오기
        getFBBoardData()

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_get, container, false)

        // BoardListLVAdpater와 연결
        boardRVAdapter = GetBoardListLVAdapter(boardDataList, boardKeyList)
        binding.boardListView.adapter = boardRVAdapter

        // 게시글 리스트 중 하나를 클릭했을 때
        binding.boardListView.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(context, GetBoardInsideActivity::class.java)
            intent.putExtra("key",boardKeyList[position])
            intent.putExtra("email", boardDataList[position].email)
            intent.putExtra("uid", boardDataList[position].uid)
            startActivity(intent)
        }

        // 돋보기 버튼을 눌렀을 때 검색 페이지(SearchGetActivity)로 이동
        binding.searchBtn.setOnClickListener {
            val intent = Intent(context, SearchGetActivity::class.java)
            startActivity(intent)
        }

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_getFragment_to_tipFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_getFragment_to_talkFragment)
        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_getFragment_to_bookmarkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_getFragment_to_storeFragment)
        }

        return binding.root
    }

    // 게시글 데이터를 받아오는 함수
    private fun getFBBoardData() {

        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear()

                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for(dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())

                    val item = dataModel.getValue(GetBoardModel::class.java)

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
        FBRef.getboardRef.addValueEventListener(postListner)
    }
}
