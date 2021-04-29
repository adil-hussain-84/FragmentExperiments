package com.tazkiyatech.app1

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

class CustomFrameLayout @JvmOverloads constructor(context: Context,
                                                  attrs: AttributeSet? = null,
                                                  defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.custom_frame_layout, this)
    }

    /**
     * Sets the given [View] as the content of this [CustomFrameLayout].
     */
    fun setContentView(view: View) {
        findViewById<ViewGroup>(R.id.contentViewGroup).removeAllViews()
        findViewById<ViewGroup>(R.id.contentViewGroup).addView(view)
    }

    /**
     * @return the [View] which represents the content of this [CustomFrameLayout].
     */
    fun getContentView(): View? {
        return findViewById<ViewGroup>(R.id.contentViewGroup).getChildAt(0)
    }
}