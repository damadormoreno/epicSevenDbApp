package com.deneb.epicsevenappdb.features.news

interface FetchDbLocal {
    fun getFetchDate(id: Int): FetchEntity
    fun addFetchDate(fetchEntity: FetchEntity): Any
}