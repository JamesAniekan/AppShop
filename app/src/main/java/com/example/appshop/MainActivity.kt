package com.example.appshop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appshop.ui.theme.AppShopTheme
import com.example.appshop.view.products.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MyMain","MyMainnnnnnn")
        setContent {
            AppShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue
                ) {
                    Greetings()
                }
            }
        }
    }
}

@Composable
fun Greeting(productName: String) {
    Text(text = productName)

}
@Composable
private fun Greetings(
    productsViewModel: ProductsViewModel = viewModel()
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = productsViewModel.products.value) { product ->
            Greeting(productName = product.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppShopTheme {
        Greetings()
    }
}