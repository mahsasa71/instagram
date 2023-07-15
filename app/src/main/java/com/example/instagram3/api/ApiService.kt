package com.example.instagram.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    var retrofit=Retrofit.Builder()
        .baseUrl("http://mobilemasters.ir/apps/instagram/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}