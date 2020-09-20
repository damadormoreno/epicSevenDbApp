package com.deneb.epicsevenappdb.features.heroes.model


import com.google.gson.annotations.SerializedName

data class Devotion(
    @SerializedName("type")
    val type: String = ""
)