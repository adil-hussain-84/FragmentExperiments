package com.tazkiyatech.app1

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var _fragmentContainer: ViewGroup? = null

    private val fragmentContainer: ViewGroup
        get() {
            var frameLayout = _fragmentContainer
            if (frameLayout == null) {
                frameLayout = FrameLayout(this)
                frameLayout.id = R.id.fragmentContainer
                frameLayout.layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                _fragmentContainer = frameLayout
            }
            return frameLayout
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val contentView = FrameLayout(this)
        contentView.id = R.id.contentView
        contentView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        val customFrameLayout = findViewById<FrameLayout>(R.id.rootView)
        customFrameLayout.addView(contentView)
    }

    override fun onResume() {
        super.onResume()

        val frameLayout = findViewById<FrameLayout>(R.id.rootView)
        val contentView = frameLayout.getChildAt(0) as ViewGroup

        contentView.removeAllViews()
        contentView.addView(fragmentContainer)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            Log.d("Foo", "Null fragment in fragmentContainer")

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ChildFragment())
                .commit()
        } else {
            Log.d("Foo", "Non-null fragment in fragmentContainer")
        }
    }
}