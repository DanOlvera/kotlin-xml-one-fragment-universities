package com.example.kotlinxmlonefragmentpractice.model.data

import com.google.gson.annotations.SerializedName

data class UniversitiesResponse(
    @SerializedName("domains"        ) var domains        : ArrayList<String> = arrayListOf(),
    @SerializedName("state-province" ) var state_province : String?           = null,
    @SerializedName("alpha_two_code" ) var alphaTwoCode   : String?           = null,
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("name"           ) var name           : String?           = null,
    @SerializedName("web_pages"      ) var webPages       : ArrayList<String> = arrayListOf()
)