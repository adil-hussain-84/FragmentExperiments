package com.tazkiyatech.app1

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val fragmentContainer by lazy {
        val frameLayout = FrameLayout(this)
        frameLayout.id = R.id.fragmentContainer
        frameLayout.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        frameLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onStart() {
        super.onStart()
        addFragmentContainer()
        addFragment()
    }

    private fun addFragmentContainer() {
        val rootView = findViewById<ViewGroup>(R.id.rootView)

        rootView.removeAllViews()
        rootView.addView(fragmentContainer)
    }

    private fun addFragment() {
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, MainFragment())
                .commit()
        }
    }
}