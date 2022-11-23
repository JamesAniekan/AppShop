package com.example.appshop.view.products

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appshop.model.Product
import com.example.appshop.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel@Inject constructor(
private val api : ApiService
): ViewModel() {

    var products : MutableState<List<Product>> = mutableStateOf( emptyList() )


    init {
        getProducts()
        Log.i("MyVM", "MYVM entered")
    }

    fun getProducts(){
        viewModelScope.launch{
            products.value = api.getProducts()

            Log.i("MyProducts", products.toString())
        }
    }
}