package com.tazkiyatech.app1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class ParentFragment : Fragment() {

    private var _fragmentContainer: ViewGroup? = null

    private val fragmentContainer: ViewGroup
        get() {
            var frameLayout = _fragmentContainer
            if (frameLayout == null) {
                frameLayout = FrameLayout(requireContext())
                frameLayout.id = R.id.fragmentContainer
                frameLayout.layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                _fragmentContainer = frameLayout
            }
            return frameLayout
        }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.parent_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contentView = FrameLayout(requireContext())
        contentView.id = R.id.contentView
        contentView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )

        val customFrameLayout = view.findViewById<CustomFrameLayout>(R.id.customFrameLayout)
        customFrameLayout.setContentView(contentView)
    }

    override fun onResume() {
        super.onResume()

        val customFrameLayout = view!!.findViewById<CustomFrameLayout>(R.id.customFrameLayout)
        val contentView = customFrameLayout.getContentView() as ViewGroup

        contentView.removeAllViews()
        contentView.addView(fragmentContainer)

        val fragment = childFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            Log.d("Foo", "Null fragment in fragmentContainer")

            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ChildFragment())
                .commit()
        } else {
            Log.d("Foo", "Non-null fragment in fragmentContainer")
        }
    }
}