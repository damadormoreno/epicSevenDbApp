package com.deneb.epicsevenappdb.core.platform

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.functional.DialogCallback
import com.deneb.epicsevenappdb.core.navigation.MainActivity
import com.deneb.epicsevenappdb.core.navigation.PopUpDelegator

abstract class BaseFragment: androidx.fragment.app.Fragment() {

    private var popUpDelegator: PopUpDelegator? = null

    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

    open fun onBackPressed() {

    }

    internal fun showProgress() = progressStatus(View.VISIBLE)

    internal fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) {
            val progress = this?.findViewById<ProgressBar>(R.id.progress)
            if (this is MainActivity) progress?.visibility = viewStatus
        }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (activity is PopUpDelegator) {
            this.popUpDelegator = activity
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is PopUpDelegator) {
            this.popUpDelegator = context
        }
    }

    internal fun showErrorWithRetry(title: String, message: String, positiveText: String,
                                    negativeText: String, callback: DialogCallback) {
        popUpDelegator?.showErrorWithRetry(title, message, positiveText, negativeText, callback)
    }

    internal fun showError(errorCode: Int, errorMessage: String?, dialogCallback: DialogCallback) {
        val genericErrorTitle = getString(R.string.generic_error_title)
        val genericErrorMessage = getString(R.string.generic_error_body)
        showErrorWithRetry(
            genericErrorTitle,
            genericErrorMessage,
            getString(R.string.Retry),
            getString(R.string.Cancel),
            object : DialogCallback {
                override suspend fun onDecline() = dialogCallback.onDecline()
                override suspend fun onAccept() = dialogCallback.onAccept()
            })
    }
}