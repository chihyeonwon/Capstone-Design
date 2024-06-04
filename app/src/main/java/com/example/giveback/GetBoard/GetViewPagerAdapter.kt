package com.example.giveback.GetBoard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.giveback.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class GetViewPagerAdapter(
    var context: Context,
    val boardKeyList: MutableList<String>,
    val key: String,
) :
    RecyclerView.Adapter<GetViewPagerAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(
            inflater.inflate(
                R.layout.image_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = boardKeyList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val storageReference = Firebase.storage.reference.child("${key}${position}.png")
        val imageViewFromFB = holder.itemView.findViewById<ImageView>(R.id.getImageArea)

        storageReference.downloadUrl.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                CoroutineScope(Dispatchers.IO).launch {
                    val downloadUrl = storageReference.downloadUrl.await()
                    withContext(Dispatchers.Main) {
                        Glide.with(context)
                            .load(downloadUrl)
                            .override(300, 200) // 이미지 사이즈
                            .skipMemoryCache(false) // 메모리에 캐싱하려면 false
                            .thumbnail(
                                Glide.with(context)
                                    .load(R.drawable.loading) // loading은 GIF 파일
                            ) // Glide로 이미지 로딩을 시작하기 전에 보여줄 이미지
                            .error(R.drawable.loading) // 리소스를 불러오다가 에러 발생 시 보여줄 이미지
                            .into(imageViewFromFB)
                    }
                }
            } else {
                // 에러 처리를 여기에 추가하세요 (예: 기본 이미지 표시)
            }
        }
    }
}