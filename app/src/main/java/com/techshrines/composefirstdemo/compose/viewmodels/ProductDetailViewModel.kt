package com.techshrines.composefirstdemo.compose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techshrines.composefirstdemo.compose.entity.ProductEntity
import com.techshrines.composefirstdemo.compose.interfaces.UiState
import com.techshrines.composefirstdemo.compose.repository.ProductRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

// ViewModel for the Detail Screen
class ProductDetailViewModel(
    private val repository: ProductRepository,
    private val productId: Int
) : ViewModel() {

    val productDetailState: StateFlow<UiState<ProductEntity>> = repository.getProductById(productId)
        .map { product ->
            if (product != null) UiState.Success(product) else UiState.Loading
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.Loading)
}