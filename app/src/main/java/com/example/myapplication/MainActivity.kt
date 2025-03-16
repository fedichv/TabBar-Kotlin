package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val fragments = arrayOf(NotificationsFragment(),Fragment2(),Fragment3(),Fragment4())

    private var activeButton: ImageButton? = null

    lateinit var button1: ImageButton
    lateinit var button2: ImageButton
    lateinit var button3: ImageButton
    lateinit var button4: ImageButton

    lateinit var line_home: View
    lateinit var line_wallet: View
    lateinit var line_analysis: View
    lateinit var line_user: View

    lateinit var tab_home: FrameLayout
    lateinit var tab_wallet: FrameLayout
    lateinit var tab_analysis: FrameLayout
    lateinit var tab_user: FrameLayout

    lateinit var text_home: TextView
    lateinit var text_wallet: TextView
    lateinit var text_analysis: TextView
    lateinit var text_user: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)

        line_home = findViewById(R.id.line_home)
        line_wallet = findViewById(R.id.line_wallet)
        line_analysis = findViewById(R.id.line_analysis)
        line_user = findViewById(R.id.line_user)

        tab_home = findViewById(R.id.tab_home)
        tab_wallet = findViewById(R.id.tab_wallet)
        tab_analysis = findViewById(R.id.tab_analysis)
        tab_user = findViewById(R.id.tab_user)

        text_home = findViewById<TextView>(R.id.text_home)
        text_wallet = findViewById<TextView>(R.id.text_wallet)
        text_analysis = findViewById<TextView>(R.id.text_analysis)
        text_user = findViewById<TextView>(R.id.text_user)

        var transaction= supportFragmentManager.beginTransaction()
        for (i in fragments) {
            transaction = transaction.add(R.id.container, i)
        }
        transaction.commit()
        switchTab(button1, R.drawable.home2, R.drawable.home, fragments[0])
        line_home.visibility = View.VISIBLE
        text_home.visibility = View.VISIBLE

        line_wallet.visibility = View.INVISIBLE
        text_wallet.visibility = View.INVISIBLE

        line_analysis.visibility = View.INVISIBLE
        text_analysis.visibility = View.INVISIBLE

        line_user.visibility = View.INVISIBLE
        text_user.visibility = View.INVISIBLE

        updateIndicatorTab(tab_home)




        button1.setOnClickListener {
            switchTab(button1, R.drawable.home2, R.drawable.home, fragments[0])
            updateIndicator(line_home)
            updateIndicatorTab(tab_home)
            updateIndicatorText(text_home)
        }
        button2.setOnClickListener {
            switchTab(button2, R.drawable.wallet2, R.drawable.wallet, fragments[1])
            updateIndicator(line_wallet)
            updateIndicatorTab(tab_wallet)
            updateIndicatorText(text_wallet)
        }
        button3.setOnClickListener {
            switchTab(button3, R.drawable.analysis2, R.drawable.analysis, fragments[2])
            updateIndicator(line_analysis)
            updateIndicatorTab(tab_analysis)
            updateIndicatorText(text_analysis)
        }
        button4.setOnClickListener {
            switchTab(button4, R.drawable.user2, R.drawable.user, fragments[3])
            updateIndicator(line_user)
            updateIndicatorTab(tab_user)
            updateIndicatorText(text_user)
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
    fun updateIndicator(activeLine: View) {
        listOf(line_home, line_wallet, line_analysis, line_user).forEach {
            it.visibility = View.INVISIBLE
        }

        activeLine.visibility = View.VISIBLE
    }

    fun updateIndicatorTab(activeTab: View) {
        listOf(tab_home, tab_wallet, tab_analysis, tab_user).forEach {
            it.setBackgroundColor(resources.getColor(android.R.color.white))
        }

        activeTab.setBackgroundColor(resources.getColor(R.color.selected_tab))
    }
    fun updateIndicatorText(activeText: View) {
        listOf(text_home, text_wallet, text_analysis, text_user).forEach {
            it.visibility = View.INVISIBLE
        }

        activeText.visibility = View.VISIBLE
    }

}