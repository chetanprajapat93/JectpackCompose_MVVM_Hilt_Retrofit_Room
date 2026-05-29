package com.asite.demopreparation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TwoActivity : AppCompatActivity() {
    val TAG = "TwoActivity Cycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
        setContentView(R.layout.activity_two)
        var button2 = findViewById(R.id.button2) as Button
        button2.setOnClickListener(){
            onBackPressed()
        }
    }

    override fun onStart() {
        Log.e(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.e(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy")
        super.onDestroy()
    }
}