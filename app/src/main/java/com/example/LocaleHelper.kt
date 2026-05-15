package com.example.raithavarta

import android.app.Activity
import java.util.Locale

object LocaleHelper {

    fun setLocale(activity: Activity, languageCode: String) {

        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources = activity.resources
        val config = resources.configuration

        config.setLocale(locale)

        resources.updateConfiguration(config, resources.displayMetrics)
    }
}