package com.example.soliddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("print ", "for (i in 1..5)")
        for (i in 1..5) {
            Log.e("print ", "$i")
        }
        Log.e("print ", "for (i in 5..1)")
        for (i in 5..1){
            Log.e("print ", "$i")
        }
        Log.e("print ", " for(i in 5 downTo 1){")
        for(i in 5 downTo 1){
            Log.e("print ", "$i")
        }
        Log.e("print ", "for(i in 5 downTo 1 step 2){")
        for(i in 5 downTo 1 step 2){
            Log.e("print ", "$i")
        }
        Log.e("print ", ((11..20 step 4).last).toString())
        for(i in (20 downTo 10 step 4))
        {
            Log.e("print ", "$i")
        }
        Log.e("print ", ((11..20 step 10).step).toString())
    }
}