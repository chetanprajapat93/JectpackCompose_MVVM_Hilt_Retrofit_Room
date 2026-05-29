package com.techshrines.composefirstdemo.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.techshrines.composefirstdemo.compose.entity.ProductEntity
import com.techshrines.composefirstdemo.compose.interfaces.UiState
import com.techshrines.composefirstdemo.compose.viewmodels.ProductListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    onProductClick: (Int) -> Unit
) {
    val state by viewModel.productListState.collectAsStateWithLifecycle()

    Scaffold(topBar = {
        TopAppBar(title = {
            Text("FakeStore Catalog")
        }
        )
    }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            when (val result = state) {
                is UiState.Loading -> CircularProgressIndicator(Modifier.align(Alignment.Center))
                is UiState.Error -> Text(
                    "Error: ${result.message}",
                    Modifier.align(Alignment.Center)
                )

                is UiState.Success -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(result.data) { product ->
                            ProductItem(product = product, onClick = { onProductClick(product.id) })
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun ProductItem(product: ProductEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.title,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2
                )
                Text(
                    text = "$${product.price}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Green
                )
                Text(
                    text = "Rating: ⭐ ${product.ratingRate}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}