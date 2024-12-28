package com.example.kotlinxmlonefragmentpractice.model.remote

import com.example.kotlinxmlonefragmentpractice.model.remote.utils.ApiUtils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(logging)
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiUtils.BASE_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}