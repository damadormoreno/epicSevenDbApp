package com.deneb.epicsevenappdb.features.heroes.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeroEntity(
    val idName: String = "",
    @PrimaryKey(autoGenerate = false)
    val id: String = "",
    val name: String = "",
    val moonlight: Boolean = false,
    val rarity: Int = 0,
    val attribute: String = "",
    val role: String = "",
    val zodiac: String = "",
    val isFavorite: Boolean = false,
    val iTake: Boolean = false,
    @Embedded
    val assets: Assets = Assets(),
)