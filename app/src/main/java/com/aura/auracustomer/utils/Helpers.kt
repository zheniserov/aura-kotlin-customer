package com.aura.auracustomer.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics
import androidx.preference.PreferenceManager
import java.util.*


object Helpers {

    fun loadLocale(context: Context) {
        val lang = PreferenceManager.getDefaultSharedPreferences(context).getString(
            "list_language_preference",
            ""
        ).toString()
        setLocale(lang, context)
    }

    fun setLocale(lang: String, context: Context) {
        val locale = Locale(lang)
        Locale.setDefault(locale)

        val resources: Resources = context.resources
        val configuration: Configuration = resources.configuration
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale)
        } else {
            configuration.locale = locale
        }
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            context.applicationContext.createConfigurationContext(configuration)
        } else {
            resources.updateConfiguration(configuration, displayMetrics)
        }

    }

    fun getToken(context: Context): String {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("token", "").toString()
    }

    fun setToken(context: Context, token: String) {
        val preference = PreferenceManager.getDefaultSharedPreferences(context).edit()
        preference.putString("token", token)
        preference.apply()
    }
}