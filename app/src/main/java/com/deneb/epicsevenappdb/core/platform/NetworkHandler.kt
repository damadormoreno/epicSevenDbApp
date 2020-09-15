package com.deneb.epicsevenappdb.core.platform

import android.content.Context
import com.deneb.epicsevenappdb.core.extensions.checkNetworkState


class NetworkHandler
(private val context: Context) {
    val isConnected get() = context.checkNetworkState()
}