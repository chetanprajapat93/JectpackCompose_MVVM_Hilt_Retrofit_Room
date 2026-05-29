package com.techshrines.composefirstdemo.compose.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.techshrines.composefirstdemo.compose.application.FakeStoreApplication
import com.techshrines.composefirstdemo.compose.ui.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cast the application context to get access to our repository instance
        val appRepository = (application as FakeStoreApplication).repository

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Send the repository down to your NavHost
                    AppNavigation(repository = appRepository)
                }
            }
        }
    }
}