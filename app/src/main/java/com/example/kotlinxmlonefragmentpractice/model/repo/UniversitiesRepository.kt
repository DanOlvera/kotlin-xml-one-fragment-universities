package com.example.kotlinxmlonefragmentpractice.model.repo

import android.util.Log
import com.example.kotlinxmlonefragmentpractice.model.data.UniversitiesResponse
import com.example.kotlinxmlonefragmentpractice.model.remote.ApiClient
import com.example.kotlinxmlonefragmentpractice.model.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object UniversitiesRepository {
    private val apiService: ApiService = ApiClient.apiService

    fun getUniversities(country: String): Flow<List<UniversitiesResponse>> = flow {
        try {
            val response = apiService.searchCountry(country)
            emit(response)
        } catch (e: Exception) {
            Log.d("TAG", "Failed to fetch list ${e.message}")
            e.printStackTrace()
            emit(emptyList())
        }
    }
}