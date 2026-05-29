package com.techshrines.composefirstdemo.customlivedata.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.techshrines.composefirstdemo.customlivedata.ui.NetworkStatusScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    NetworkStatusScreen()
                }
            }
        }
    }
}