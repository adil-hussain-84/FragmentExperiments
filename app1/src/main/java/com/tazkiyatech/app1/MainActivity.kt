package com.tazkiyatech.app1

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val fragment = supportFragmentManager.findFragmentById(R.id.rootView)

        if (fragment == null) {
            Log.d("Foo", "Null fragment in rootView")
            supportFragmentManager.beginTransaction()
                .replace(R.id.rootView, ParentFragment())
                .commit()
        } else {
            Log.d("Foo", "Non-null fragment in rootView")
        }
    }
}