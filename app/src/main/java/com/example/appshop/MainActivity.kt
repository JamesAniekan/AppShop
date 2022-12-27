package com.example.appshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appshop.ui.theme.AppShopTheme
import com.example.appshop.view.productDetails.ProductDetailsScreen
import com.example.appshop.view.products.ProductsScreen
import com.example.appshop.view.products.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           AppShop()
        }
    }

//    @Preview(showBackground = true)
//    @Composable
//    fun DefaultPreview() {
//        AppShopTheme {
//            ProductsScreen()
//        }
//    }
}

@Composable
fun AppShop(){
    AppShopTheme {
        val navController = rememberNavController()

        NavHost(navController = navController,
            startDestination = "product_list"){

            composable(route = "product_list"){
                val model: ProductsViewModel = hiltViewModel()
                ProductsScreen(productsViewModel = model){
                    navController.navigateSingleTopTo("product_details/$it")
                }
            }
            composable(route = "product_details/{productId}",
                arguments = listOf(
                    navArgument("productId"){type = NavType.IntType}
                )
            ){ navBackStackEntry ->
                val productId = navBackStackEntry.arguments?.getInt("productId")
               ProductDetailsScreen(productId)
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route){
        launchSingleTop = true
    }