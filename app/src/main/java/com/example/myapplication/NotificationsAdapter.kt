package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotificationsAdapter(val items: Array<RecyclerItemModel>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if(item is HeaderItemModel && holder is HeaderViewHolder){
            holder.textView.text = item.title
        } else if(item is FollowItemModel && holder is FollowNotificationViewHolder) {
            holder.imageView.setImageResource(item.image)
            holder.textView.text = item.name
            holder.button.text = item.button
        } else if(item is LikesItemModel && holder is LikesViewHolder) {
            holder.imageView.setImageResource(item.image)
            holder.textView.text = item.name
            holder.imageView1.setImageResource(item.image2)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
//        if (item is HeaderItemModel) {
//            return 0
//        } else if (item is FollowItemModel) {
//            return 1
//        } else {
//            return 2
//        }
        return when(item) {
            is HeaderItemModel -> 0
            is FollowItemModel -> 1
            else -> 2
        }
    }
}