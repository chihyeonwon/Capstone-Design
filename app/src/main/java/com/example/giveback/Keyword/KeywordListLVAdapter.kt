package com.example.giveback.Keyword

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.giveback.QnABoard.KeywordStatusModel
import com.example.giveback.R
import com.example.giveback.utils.FBRef

// 리스트뷰와 게시글 데이터를 연결해주는 게시물 리스트 어댑터
class KeywordListLVAdapter(val boardList : MutableList<KeywordStatusModel>, val boardKeyList: MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // view를 가져와서 item과 연결해주는 부분
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        //if(view== null) {

        view = LayoutInflater.from(parent?.context).inflate(R.layout.keyword_list_item, parent,false)
        //}

        val keyword = view?.findViewById<TextView>(R.id.keywordArea)
        val removeBtn = view?.findViewById<ImageView>(R.id.removeBtn)

        removeBtn?.setOnClickListener {
            FBRef.keywordRef.child(boardKeyList[position]).removeValue()
        }

        keyword!!.text = "등록된 키워드명: ${boardList[position].category}"

        return view!!
    }
}