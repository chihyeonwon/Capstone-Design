package com.example.giveback.fragments

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.giveback.QnABoard.QnaBoardInsideActivity
import com.example.giveback.QnABoard.QnaBoardListLVAdapter
import com.example.giveback.QnABoard.QnaBoardModel
import com.example.giveback.QnABoard.QnaBoardWriteActivity
import com.example.giveback.R
import com.example.giveback.databinding.FragmentQnaBinding
import com.example.giveback.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

// QnA 페이지
class QnAFragment : Fragment() {

    private lateinit var binding: FragmentQnaBinding

    private val boardDataList = mutableListOf<QnaBoardModel>()
    private val boardKeyList = mutableListOf<String>()

    private lateinit var boardRVAdapter: QnaBoardListLVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_qna, container, false)

        // BoardListLVAdpater와 연결
        boardRVAdapter = QnaBoardListLVAdapter(boardDataList,  boardKeyList)
        binding.boardListView.adapter = boardRVAdapter


        // QnA 화면의 QnaWriteBtn을 클릭하면 QnaBoardWriteActivity로 이동하도록 화면 이동 기능 구현
        binding.QnaBtn.setOnClickListener{
            val intent = Intent(context, QnaBoardWriteActivity::class.java)
            startActivity(intent)
        }

        // 게시글 리스트 중 하나를 클릭했을 때
        binding.boardListView.setOnItemClickListener { parent, view, position, id ->
            /*val intent = Intent(context,GetBoardInsideActivity::class.java)
            intent.putExtra("title",boardDataList[position].title)
            intent.putExtra("content",boardDataList[position].content)
            intent.putExtra("time",boardDataList[position].time)
            startActivity(intent)*/

            val intent = Intent(context, QnaBoardInsideActivity::class.java)
            intent.putExtra("key",boardKeyList[position])
            startActivity(intent)
        }

        getFBBoardData()

        binding.tipTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_qnaFragment_to_tipFragment)
        }

        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_qnaFragment_to_homeFragment)
        }

        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_qnaFragment_to_talkFragment)
        }

        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_qnaFragment_to_storeFragment)
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
                    Log.d(ContentValues.TAG, dataModel.toString())

                    val item = dataModel.getValue(QnaBoardModel::class.java)
                    boardDataList.add(item!!)
                    boardKeyList.add(dataModel.key.toString())
                }

                boardKeyList.reverse()
                // 최신 게시글이 앞으로 오도록 리스트를 뒤집는다.
                boardDataList.reverse()

                // boardRVAdapter 동기화
                boardRVAdapter.notifyDataSetChanged()

                Log.d(ContentValues.TAG, boardDataList.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.qnaboardRef.addValueEventListener(postListner)
    }
}