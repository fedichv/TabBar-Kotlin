package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotificationsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if(viewType == 0) {
            val itemView = inflater.inflate(R.layout.item_header, parent, false)
            return HeaderViewHolder(itemView)
        } else if(viewType == 1) {
            val itemView = inflater.inflate(R.layout.item_follower, parent, false)
            return FollowNotificationViewHolder(itemView)
        } else if(viewType == 2) {
            val itemView = inflater.inflate(R.layout.item_likes, parent, false)
            return LikesViewHolder(itemView)
        } else {
            TODO("sdfghjk")
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        if(position % 3 == 0) {
            return 0
        } else if(position % 3 == 1) {
            return 1
        } else {
            return 2
        }
    }
}