package com.example.kotlinxmlonefragmentpractice.model.remote

import com.example.kotlinxmlonefragmentpractice.model.data.UniversitiesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun searchCountry(
        @Query("country") country: String
    ): List<UniversitiesResponse>
}