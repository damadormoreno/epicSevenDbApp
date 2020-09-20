package com.deneb.epicsevenappdb.features.heroes.model


import com.google.gson.annotations.SerializedName

data class HeroNetwork(
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
    val buffs: List<Any> = listOf(),
    @SerializedName("debuffs")
    val debuffs: List<Any> = listOf(),
    @SerializedName("common")
    val common: List<Any> = listOf()
) {
    fun toHeroEntity(): HeroEntity{
        return HeroEntity(
            _id,id, name, moonlight, rarity, attribute, role, zodiac, assets = assets
        )
    }
}