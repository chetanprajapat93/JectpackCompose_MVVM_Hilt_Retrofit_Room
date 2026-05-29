package com.asite.demopreparation
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentTwo: Fragment() {

    val TAG = "FragmentTwo Cycle"

    override fun onAttach(context: Context) {
        Log.e(TAG, "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e(TAG, "onCreateView")
        var view = inflater.inflate(R.layout.fragment_two, null)
        return inflater.inflate(R.layout.fragment_two, null)//super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e(TAG, "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        var btn = view.findViewById<Button>(R.id.button4)
        btn.setOnClickListener(){
            childFragmentManager!!.popBackStack()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.e(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.e(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e(TAG, "onResume")
        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.e(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.e(TAG, "onViewStateRestored")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onPause() {
        Log.e(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.e(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.e(TAG, "onDetach")
        super.onDetach()
    }


}