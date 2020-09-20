package com.deneb.epicsevenappdb.features.heroes.model


import com.google.gson.annotations.SerializedName

data class SelfDevotion(
    @SerializedName("type")
    val type: String = ""
)