package com.techshrines.composefirstdemo.customlivedata.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.techshrines.composefirstdemo.customlivedata.viewmodel.MainViewModel

@Composable
fun NetworkStatusScreen(
    // Inject your ViewModel using the compose-viewmodel artifact
    mainViewModel: MainViewModel = viewModel()
) {
    // 1. Convert LiveData to Compose State using 'by observeAsState'
    // We pass a default value (false) to ensure the state is non-null from the start
    val isConnected by mainViewModel.networkStatus.observeAsState(initial = false)

    // 2. The UI automatically recomposes whenever 'isConnected' changes
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isConnected) Color(0xFFE8F5E9) else Color(0xFFFFEBEE)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = if (isConnected) "You are Online" else "No Internet Connection",
                style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
                color = if (isConnected) Color(0xFF2E7D32) else Color(0xFFC62828)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "The UI updates automatically using Compose State",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}