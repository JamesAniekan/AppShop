package com.example.appshop.network

import com.example.appshop.model.Product
import retrofit2.http.GET


interface ApiService {

    @GET("products")
     suspend fun getProducts(): List<Product>
}