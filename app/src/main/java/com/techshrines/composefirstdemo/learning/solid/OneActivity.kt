package com.asite.demopreparation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class OneActivity : AppCompatActivity() {
    val TAG = "NewActivity Cycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate")
        setContentView(R.layout.activity_one)
        var button1 = findViewById(R.id.button1) as Button
        button1.setOnClickListener(){
            //val intent = Intent(this, TwoActivity::class.java)
            //getResult.launch(intent)
            replaceFragmentOne()
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

    // Receiver
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            Log.e(TAG, "StartActivityForResult")
            if(it.resultCode == Activity.RESULT_OK){
                val value = it.data?.getStringExtra("input")
            }
        }

    fun replaceFragmentOne(){
        val ft: FragmentTransaction = supportFragmentManager!!.beginTransaction()
        ft.replace(R.id.frameContainer, FragmentOne(), "FragmentOne")
        ft.addToBackStack(null);
        ft.commit()
    }

    fun addFragmentOne(){
        val ft: FragmentTransaction = supportFragmentManager!!.beginTransaction()
        ft.add(R.id.frameContainer, FragmentOne(), "FragmentOne")
        ft.addToBackStack(null);
        ft.commit()
    }

    fun replaceFragmentTwo(){
        val ft: FragmentTransaction = supportFragmentManager!!.beginTransaction()
        ft.replace(R.id.frameContainer, FragmentTwo(), "FragmentTwo")
        ft.addToBackStack(null);
        ft.commit()
    }

    fun addFragmentTwo(){
        val ft: FragmentTransaction = supportFragmentManager!!.beginTransaction()
        ft.add(R.id.frameContainer, FragmentTwo(), "FragmentTwo")
        ft.addToBackStack(null);
        ft.commit()
    }
}