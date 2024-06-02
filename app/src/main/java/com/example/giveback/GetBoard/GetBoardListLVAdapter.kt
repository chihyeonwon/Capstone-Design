package com.example.giveback.GetBoard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.giveback.R
import com.example.giveback.utils.FBAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

// 리스트뷰와 게시글 데이터를 연결해주는 게시물 리스트 어댑터
class GetBoardListLVAdapter(val boardList : MutableList<GetBoardModel>, val boardKeyList: MutableList<String>): BaseAdapter() {
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

        view = LayoutInflater.from(parent?.context).inflate(R.layout.get_board_list_item, parent,false)
        //}

        val imageViewFromFB = view?.findViewById<ImageView>(R.id.imageArea)

        val storageReference = Firebase.storage.reference.child("${boardKeyList[position]}0.png")

        storageReference.downloadUrl.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUrl = task.result

                if (imageViewFromFB != null) {

                    Glide.with(view)
                        .load(downloadUrl)
                        .override(300, 200) // 이미지 사이즈
                        .skipMemoryCache(false) // 메모리에 캐싱하려면 false
                        .diskCacheStrategy(DiskCacheStrategy.ALL) // 모든 이미지를 캐싱(기본값)
                        .thumbnail(
                            Glide.with(view).load(R.drawable.loading) // loading은 GIF 파일
                        ) // Glide로 이미지 로딩을 시작하기 전에 보여줄 이미지
                        .error(R.drawable.loading) //리소스를 불러오다가 에러 발생 시 보여줄 이미지
                        .into(imageViewFromFB)
                }
            } else {

            }
        }

        val title = view?.findViewById<TextView>(R.id.titleArea)
        val getLocation = view?.findViewById<TextView>(R.id.getlocationArea)
        val keepLocation = view?.findViewById<TextView>(R.id.keeplocationArea)
        val getDate = view?.findViewById<TextView>(R.id.getDateArea)

        val itemLinearLayoutView = view?.findViewById<LinearLayout>(R.id.itemView)
        if(boardList[position].uid.equals(FBAuth.getUid())) {
            itemLinearLayoutView?.setBackgroundColor(Color.parseColor("#EEEEEE"))
        }

        title!!.text = boardList[position].title
        getLocation!!.text = "${boardList[position].getLocation} ${boardList[position].getdetailLocation}"
        keepLocation!!.text = "${boardList[position].keepLocation} ${boardList[position].keepdetailLocation}"
        getDate!!.text = boardList[position].getDate

        return view!!
    }


}