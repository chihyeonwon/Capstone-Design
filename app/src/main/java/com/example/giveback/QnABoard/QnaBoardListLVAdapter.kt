package com.example.giveback.QnABoard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.example.giveback.R
import com.example.giveback.utils.FBRef
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

// 리스트뷰와 게시글 데이터를 연결해주는 게시물 리스트 어댑터
class QnaBoardListLVAdapter(val boardList : MutableList<QnaBoardModel>, val boardKeyList: MutableList<String>): BaseAdapter() {
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

            view = LayoutInflater.from(parent?.context).inflate(R.layout.qna_board_list_item, parent,false)
        //}

        val email = view?.findViewById<TextView>(R.id.emailArea)
        val title = view?.findViewById<TextView>(R.id.titleArea)
        val status = view?.findViewById<TextView>(R.id.statusArea)

        val itemLinearLayoutView = view?.findViewById<LinearLayout>(R.id.itemView)

        // ChildEventListener 등록
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                // 글이 추가되었을 때 처리하는 로직
                status?.text = "완료"
                itemLinearLayoutView?.setBackgroundColor(Color.parseColor("#00FF80"))
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
        FBRef.commentRef.child(boardKeyList[position]).addChildEventListener(childEventListener)

        val atIndex = boardList[position].email.indexOf("@") // @의 인덱스 추출

        // 문자가 4개 이상일때
        if (atIndex >= 4) {
            // 앞의 문자 4개는 그냥 출력하고
            val maskedPart = boardList[position].email.substring(0, 4) +
                    "*".repeat(atIndex - 4) + // 뒤에꺼는 *로 대체하고
                    boardList[position].email.substring(atIndex) // @뒤는 그대로 표시

            email!!.text = maskedPart

        } else {
            email!!.text = boardList[position].email
        }

        title!!.text = boardList[position].title
        status!!.text = boardList[position].status

        return view!!
    }

}