package com.example.giveback.Keyword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.giveback.GetBoard.GetBoardInsideActivity
import com.example.giveback.GetBoard.GetBoardListLVAdapter
import com.example.giveback.GetBoard.GetBoardModel
import com.example.giveback.MainActivity
import com.example.giveback.R
import com.example.giveback.databinding.ActivityKeywordSearchedBinding
import com.example.giveback.databinding.ActivitySearchedBinding
import com.example.giveback.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.Date

class KeywordSearchedActivity : AppCompatActivity() {

    private val boardDataList = mutableListOf<GetBoardModel>()
    private val boardKeyList = mutableListOf<String>()

    private lateinit var boardRVAdapter: GetBoardListLVAdapter

    private lateinit var binding: ActivityKeywordSearchedBinding

    private lateinit var searchtitle: String
    private lateinit var startDate: Date
    private lateinit var endDate: Date
    private lateinit var getlocation: String

    val sdf = SimpleDateFormat("yyyy년 MM월 dd일")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_keyword_searched)

        // BoardListLVAdpater와 연결
        boardRVAdapter = GetBoardListLVAdapter(boardDataList, boardKeyList)
        binding.boardListView.adapter = boardRVAdapter

        // 게시글 리스트 중 하나를 클릭했을 때
        binding.boardListView.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, GetBoardInsideActivity::class.java)
            intent.putExtra("key",boardKeyList[position])
            startActivity(intent)
        }

        searchtitle = intent.getStringExtra("물품명").toString()
        startDate = sdf.parse(intent.getStringExtra("시작일").toString())
        endDate = sdf.parse(intent.getStringExtra("종료일").toString())
        getlocation = intent.getStringExtra("습득위치").toString()

        getFBBoardData(searchtitle)

        // 되돌아기 버튼을 눌렀을 때 GetFragment로 이동
        binding.backGetFragment.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getFBBoardData(searchtitle:String) {

        val postListner = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear()

                // dataModel에 있는 데이터를 하나씩 가져오는 부분
                for(dataModel in dataSnapshot.children) {

                    val item = dataModel.getValue(GetBoardModel::class.java)

                    val sdfDate = sdf.parse(item?.getDate)

                    if(searchtitle.equals(item?.title.toString()) &&
                        (sdfDate <= endDate && sdfDate >= startDate))
                    {
                        boardDataList.add(item!!)
                        boardKeyList.add(dataModel.key.toString())
                    }

                }


                boardKeyList.reverse()
                // 최신 게시글이 앞으로 오도록 리스트를 뒤집는다.
                boardDataList.reverse()

                // boardRVAdapter 동기화
                boardRVAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        FBRef.getboardRef.addValueEventListener(postListner)
    }
}