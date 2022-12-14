package com.example.appshop.view.products

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.appshop.model.Product


@Composable
fun ProductsScreen(
    productsViewModel: ProductsViewModel = viewModel()
) {
    Column(modifier = Modifier.paddingFromBaseline(20.dp)) {
        Surface(color = Color.LightGray, modifier = Modifier.paddingFromBaseline(bottom = 30.dp),
        shape = MaterialTheme.shapes.small) {
           Column {
               TopBar()
               WelcomeText()
           }
        }
        CategoryRow(productsViewModel = productsViewModel)
        Spacer(modifier = Modifier.height(10.dp))
        ProductsGrid(productsViewModel = productsViewModel)
    }

}

@Composable
fun ProductCard(product: Product) {
    Surface(
        color = Color.White,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        shadowElevation = 20.dp
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = rememberAsyncImagePainter(model = product.image),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(90.dp),
                contentDescription = null )
           // Text(text = product.title, style = MaterialTheme.typography.titleSmall)
            Text(text = product.category,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(75.dp)) {
                Text(text = product.price.toString())
                Icon(Icons.Rounded.ShoppingCart, contentDescription = null)
            }
        }
    }
}

@Composable
fun ProductsGrid(productsViewModel: ProductsViewModel) {
    LazyVerticalGrid(
       columns =GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = productsViewModel.products.value) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun WelcomeText(modifier: Modifier = Modifier){
    Column(modifier.height(56.dp)) {
        Text(text = "Welcome, Barry Tone",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.paddingFromBaseline(top = 4.dp)
        )
        Text(text = "Let's find a stylish watch for you",
            style = MaterialTheme.typography.titleSmall)
    }
}

@Composable
fun CategoryRow(productsViewModel: ProductsViewModel){
    LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp) ) {
       items(items = productsViewModel.categories.value){ category ->
            ProdCategory(category = category)
       }
    }
}

@Composable
fun ProdCategory(category: String){
    Surface(color = Color.LightGray, modifier = Modifier.height(30.dp),
        shape = MaterialTheme.shapes.small) {
        Text(text = category,
            modifier = Modifier.padding(4.dp),
        fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    Surface(modifier = Modifier.fillMaxWidth(), color = Color.LightGray) {
        Row(horizontalArrangement = Arrangement.spacedBy(250.dp)) {
            Text(text = "Products",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold)
            Surface(color = Color.LightGray, modifier = Modifier.paddingFromBaseline(top = 10.dp)) {
                Box() {
                    Icon(Icons.Rounded.ShoppingCart, contentDescription = null)
                    Badge(containerColor = Color.Red){
                       Text(text = "2")
                }
            }
        }

        }
    }

}

