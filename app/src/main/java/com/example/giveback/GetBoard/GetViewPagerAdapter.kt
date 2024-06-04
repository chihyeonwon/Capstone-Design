package com.example.giveback.GetBoard

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.giveback.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class GetViewPagerAdapter(val boardKeyList: MutableList<String>, val key: String, val count: Int) :
    RecyclerView.Adapter<GetViewPagerAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = boardKeyList.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        // 사진을 차례대로 받아서 이미지뷰0~5번에 뿌림
        for (i in 0 until count) {

            val storageReference = Firebase.storage.reference.child("${key}${i}.png")

            val imageViewFromFB = holder.Image

            storageReference.downloadUrl.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUrl = task.result
                    if (imageViewFromFB != null) {
                        Glide.with(holder.itemView)
                            .load(downloadUrl)
                            .into(imageViewFromFB)
                    }
                } else {
                    imageViewFromFB?.visibility = View.GONE
                }
            }
            holder.Image.setImageResource(
                holder.itemView.resources.getIdentifier(
                    "getImageArea",
                    "id",
                    "com.example.giveback"
                )
            ) as ImageView
        }
    }

    inner class PagerViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_layout, parent, false)
        ) {

        var Image = itemView.findViewById<ImageView>(R.id.getImageArea)!!
    }
}