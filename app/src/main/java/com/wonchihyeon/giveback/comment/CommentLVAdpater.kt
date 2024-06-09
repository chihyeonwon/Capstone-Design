package com.wonchihyeon.giveback.comment

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.wonchihyeon.giveback.R
import com.wonchihyeon.giveback.utils.FBAuth
import com.wonchihyeon.giveback.utils.FBRef
import com.wonchihyeon.giveback.utils.FcmPush

// 리스트뷰와 댓글 데이터를 연결해주는 어댑터
class CommentLVAdpater(val commentList:MutableList<CommentModel>, val key: String, val uid: String) :  BaseAdapter() {
    override fun getCount(): Int {
        return commentList.size
    }

    override fun getItem(position: Int): Any {
        return commentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if(view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.comment_list_item, parent,false)
        }

        val title = view?.findViewById<TextView>(R.id.titleArea)
        val time = view?.findViewById<TextView>(R.id.timeArea)

        title!!.text = commentList[position].commentTitle
        time!!.text = commentList[position].commentCreatedTime

        return view!!
    }

}