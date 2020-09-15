package com.deneb.epicsevenappdb.core.navigation

import com.deneb.epicsevenappdb.core.functional.DialogCallback

interface PopUpDelegator {

    fun showErrorWithRetry(title: String, message: String, positiveText: String,
                           negativeText: String, callback: DialogCallback
    )
}