package com.example.kotlinxmlonefragmentpractice.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinxmlonefragmentpractice.model.data.UniversitiesResponse
import com.example.kotlinxmlonefragmentpractice.model.repo.UniversitiesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UniversitiesViewModel: ViewModel() {

    val repository = UniversitiesRepository

    private val _uniList = MutableStateFlow<List<UniversitiesResponse>>(emptyList())
    val uniList: StateFlow<List<UniversitiesResponse>> = _uniList

    private val _selectUniv = MutableStateFlow<UniversitiesResponse?>(null)
    val selectUniv: StateFlow<UniversitiesResponse?> = _selectUniv

    init {
        getUniversitiesList("United States")
    }

    fun getUniversitiesList(country: String) {
        viewModelScope.launch {
            try {
                repository.getUniversities(country).collect { response ->
                    _uniList.value = response
                }
            } catch (e: Exception) {
                Log.d("TAG", "getUniversitiesList: Something happened")
            }
        }
    }
}