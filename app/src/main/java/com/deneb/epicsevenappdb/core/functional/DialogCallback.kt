package com.deneb.epicsevenappdb.core.functional

interface DialogCallback {
    suspend fun onAccept()
    suspend fun onDecline()
}