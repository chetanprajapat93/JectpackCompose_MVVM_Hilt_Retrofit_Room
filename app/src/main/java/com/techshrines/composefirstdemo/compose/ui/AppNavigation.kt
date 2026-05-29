package com.techshrines.composefirstdemo.compose.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techshrines.composefirstdemo.compose.repository.ProductRepository
import com.techshrines.composefirstdemo.compose.viewmodels.ProductDetailViewModel
import com.techshrines.composefirstdemo.compose.viewmodels.ProductListViewModel

@Composable
fun AppNavigation(repository: ProductRepository) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "product_list") {

        // Product List Route
        composable("product_list") {
            val factory = viewModelFactory { ProductListViewModel(repository) }
            val viewModel: ProductListViewModel = viewModel(factory = factory)
            ProductListScreen(viewModel = viewModel) { productId ->
                navController.navigate("product_detail/$productId")
            }
        }

        // Product Detail Route
        composable(
            route = "product_detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            val factory = viewModelFactory { ProductDetailViewModel(repository, productId) }
            val viewModel: ProductDetailViewModel = viewModel(factory = factory)

            ProductDetailScreen(viewModel = viewModel) {
                navController.popBackStack()
            }
        }
    }
}

// Quick Inline ViewModel Factory Helper
inline fun <VM : ViewModel> viewModelFactory(crossinline f: () -> VM) =
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = f() as T
    }