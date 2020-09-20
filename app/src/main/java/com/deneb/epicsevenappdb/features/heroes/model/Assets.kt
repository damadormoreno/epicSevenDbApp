package com.deneb.epicsevenappdb.features.heroes.model


import com.google.gson.annotations.SerializedName

data class Assets(
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("thumbnail")
    val thumbnail: String = ""
)