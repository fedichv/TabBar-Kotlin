package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textView = itemView.findViewById<TextView>(R.id.headerTextView)
}