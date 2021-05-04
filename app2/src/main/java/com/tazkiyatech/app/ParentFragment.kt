package com.tazkiyatech.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class ParentFragment : Fragment() {

    private val fragmentContainerView by lazy {
        FragmentContainerView(requireContext()).apply {
            id = R.id.fragmentContainerView
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.parent_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        addFragmentContainerView() // move this call to 'onViewCreated(view:savedInstanceState:)' for the 'MainActivityInstrumentedTest.recreate_activity()' test method to pass
        addFragment()
    }

    private fun addFragmentContainerView() {
        val rootView = requireView().findViewById<ViewGroup>(R.id.rootView)

        rootView.removeAllViews()
        rootView.addView(fragmentContainerView)
    }

    private fun addFragment() {
        if (childFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            childFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, ChildFragment())
                .commit()
        }
    }
}