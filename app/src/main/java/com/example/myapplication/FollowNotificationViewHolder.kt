package com.example.myapplication

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FollowNotificationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val textView: TextView = itemView.findViewById(R.id.textView)
    val button: Button = itemView.findViewById(R.id.button)
}