package com.example.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LikesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val textView: TextView = itemView.findViewById(R.id.textView)
    val imageView1: ImageView = itemView.findViewById(R.id.imageView1)
}