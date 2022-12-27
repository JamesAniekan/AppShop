package com.example.appshop.view.productDetails

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
class ProductDetailsVM@Inject constructor(private val api: ApiService) : ViewModel(){

     var product : MutableState<Product?> = mutableStateOf(null)

    fun getProduct(productId: Int): Product? {
        viewModelScope.launch {
            product.value = api.getProduct(productId)
        }

        return product.value
    }

}