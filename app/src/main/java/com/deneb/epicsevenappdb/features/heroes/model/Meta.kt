package com.deneb.epicsevenappdb.features.heroes.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("requestDate")
    val requestDate: String = "",
    @SerializedName("apiVersion")
    val apiVersion: String = ""
)