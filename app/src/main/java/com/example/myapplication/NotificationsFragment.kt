package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationsFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = NotificationsAdapter(
            arrayOf(
                HeaderItemModel("Today"),
                FollowItemModel(R.drawable.ic_launcher_foreground, "Dean Winchester", "Hello"),
                HeaderItemModel("Yesterday"),
                LikesItemModel(R.drawable.ic_launcher_background, "Петр Иванов", R.drawable.ic_launcher_background)
            )
        )
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}
