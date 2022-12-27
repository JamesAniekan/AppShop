package com.example.appshop.view.productDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProductDetailsScreen(productId: Int? = 3){
    val model: ProductDetailsVM = hiltViewModel()
    val product = productId?.let { model.getProduct(it) }
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Blue) {
       // val product = remember{ mutableStateOf(productId) }


        if (product != null) {
            Text(text = product.title)
        }
    }
}

@Composable
fun ProductImage(){
    Image(painter = rememberAsyncImagePainter(model = null),
        contentDescription = null)
}

@Composable
fun ProductDescription(){
    Text(text = "null")
}

@Composable
fun AddToCart(){
    
}

