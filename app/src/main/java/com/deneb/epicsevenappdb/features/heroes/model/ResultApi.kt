package com.deneb.epicsevenappdb.features.heroes.model


import com.google.gson.annotations.SerializedName

data class ResultApi(
    @SerializedName("results")
    val heroNetworks: List<HeroNetwork> = listOf(),
    @SerializedName("meta")
    val meta: Meta = Meta()
){
    companion object {
        fun empty(): ResultApi =
            ResultApi()
    }
}