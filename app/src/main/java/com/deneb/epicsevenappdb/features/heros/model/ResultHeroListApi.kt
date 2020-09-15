package com.deneb.epicsevenappdb.features.heros.model


import com.google.gson.annotations.SerializedName

data class ResultHeroListApi(
    @SerializedName("results")
    val results: List<Result> = listOf(),
    @SerializedName("meta")
    val meta: Meta = Meta()
) {
    data class Result(
        @SerializedName("_id")
        val _id: String = "",
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("moonlight")
        val moonlight: Boolean = false,
        @SerializedName("rarity")
        val rarity: Int = 0,
        @SerializedName("attribute")
        val attribute: String = "",
        @SerializedName("role")
        val role: String = "",
        @SerializedName("zodiac")
        val zodiac: String = "",
        @SerializedName("self_devotion")
        val selfDevotion: SelfDevotion = SelfDevotion(),
        @SerializedName("devotion")
        val devotion: Devotion = Devotion(),
        @SerializedName("assets")
        val assets: Assets = Assets(),
        @SerializedName("buffs")
        val buffs: List<Int> = listOf(),
        @SerializedName("debuffs")
        val debuffs: List<Int> = listOf(),
        @SerializedName("common")
        val common: List<Int> = listOf()
    ) {
        data class SelfDevotion(
            @SerializedName("type")
            val type: String = ""
        )

        data class Devotion(
            @SerializedName("type")
            val type: String = ""
        )

        data class Assets(
            @SerializedName("icon")
            val icon: String = "",
            @SerializedName("image")
            val image: String = "",
            @SerializedName("thumbnail")
            val thumbnail: String = ""
        )
    }

    data class Meta(
        @SerializedName("requestDate")
        val requestDate: String = "",
        @SerializedName("apiVersion")
        val apiVersion: String = ""
    )
}