package com.example.appshop.network

import com.example.appshop.model.Product
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("products")
     suspend fun getProducts(): List<Product>
     @GET("products/categories")
     suspend fun getCategories(): List<String>
     @GET("products/{id}")
     suspend fun getProduct(@Path(value="id")productId: Int): Product
}