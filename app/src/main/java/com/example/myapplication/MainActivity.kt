package com.example.myapplication

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment

class MainActivity : AppCompatActivity() {
    val fragments = arrayOf(NotificationsFragment(),Fragment2(),Fragment3(),Fragment4())

    private var activeButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button1 = findViewById<ImageButton>(R.id.button1)
        val button2 = findViewById<ImageButton>(R.id.button2)
        val button3 = findViewById<ImageButton>(R.id.button3)
        val button4 = findViewById<ImageButton>(R.id.button4)

        var transaction= supportFragmentManager.beginTransaction()
        for (i in fragments) {
            transaction = transaction.add(R.id.container, i)
        }
        transaction.commit()
        switchTab(button1, R.drawable.home2, R.drawable.home, fragments[0])


        button1.setOnClickListener {
            switchTab(button1, R.drawable.home2, R.drawable.home, fragments[0])
        }
        button2.setOnClickListener {
            switchTab(button2, R.drawable.wallet2, R.drawable.wallet, fragments[1])
        }
        button3.setOnClickListener {
            switchTab(button3, R.drawable.analysis2, R.drawable.analysis, fragments[2])
        }
        button4.setOnClickListener {
            switchTab(button4, R.drawable.user2, R.drawable.user, fragments[3])
        }
    }

    private fun switchTab(button: ImageButton, activeIcon: Int, defaultIcon: Int, fragmentTrue: Fragment) {

        activeButton?.setImageResource(activeButton?.tag as? Int ?: 0)

        button.setImageResource(activeIcon)

        activeButton = button
        activeButton?.tag = defaultIcon

        var transaction = supportFragmentManager.beginTransaction()
        for (fragment in fragments) {
            transaction = transaction.hide(fragment)
        }
        transaction.show(fragmentTrue)
        transaction.commit()
    }
}