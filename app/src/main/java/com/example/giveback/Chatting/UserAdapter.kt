package com.example.giveback.Chatting

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.giveback.R
import com.example.giveback.auth.User

class UserAdapter(private val context: android.content.Context, private val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    /**
     * 화면 설정
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).
        inflate(R.layout.user_layout, parent, false)

        return UserViewHolder(view)
    }

    /**
     * 데이터 설정
     */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        //데이터 담기
        val currentUser = userList[position]

        //화면에 데이터 보여주기
        holder.nameText.text = currentUser.email

        //아이템 클릭 이벤트
        holder.itemView.setOnClickListener {

            val intent  = Intent(context, ChatActivity::class.java)

            //넘길 데이터
            intent.putExtra("email", currentUser.email)
            intent.putExtra("uid", currentUser.uId)

            context.startActivity(intent)
        }
    }

    /**
     * 데이터 갯수 가져오기
     */
    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nameText: TextView = itemView.findViewById(R.id.name_text)
    }
}