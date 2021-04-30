package com.tazkiyatech.app1

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {

    private val fragmentContainerView by lazy {
        FragmentContainerView(this).apply {
            id = R.id.fragmentContainerView
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onStart() {
        super.onStart()
        addFragmentContainer() // move this call to 'onCreate(savedInstanceState:)' for the 'MainActivityInstrumentedTest.recreate_activity()' test method to pass
        addFragment()
    }

    private fun addFragmentContainer() {
        val rootView = findViewById<ViewGroup>(R.id.rootView)

        rootView.removeAllViews()
        rootView.addView(fragmentContainerView)
    }

    private fun addFragment() {
        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, MainFragment())
                .commit()
        }
    }
}