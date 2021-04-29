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

        val rootView = findViewById<FrameLayout>(R.id.rootView)
        rootView.addView(contentView)
    }

    override fun onStart() {
        super.onStart()

        val rootView = findViewById<FrameLayout>(R.id.rootView)
        val contentView = rootView.getChildAt(0) as ViewGroup

        contentView.removeAllViews()
        contentView.addView(fragmentContainer)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            Log.d("Foo", "Null fragment in fragmentContainer")

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MainFragment())
                .commit()
        } else {
            Log.d("Foo", "Non-null fragment in fragmentContainer")
        }
    }
}