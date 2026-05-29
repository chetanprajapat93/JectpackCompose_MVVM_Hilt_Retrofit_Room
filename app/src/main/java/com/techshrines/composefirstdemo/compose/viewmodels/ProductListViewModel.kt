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
import kotlinx.coroutines.launch

class ProductListViewModel(private val repository: ProductRepository): ViewModel() {
    val productListState: StateFlow<UiState<List<ProductEntity>>> = repository.getProducts()
        .map {
            entityList ->
            if(entityList.isEmpty()) UiState.Loading else UiState.Success(entityList)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.Loading)

    init {
        fetchNewData()
    }

    fun fetchNewData() {
        viewModelScope.launch {
            repository.refreshProducts()
        }
    }
}