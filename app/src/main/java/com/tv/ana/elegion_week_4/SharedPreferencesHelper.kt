package com.tv.ana.elegion_week_4

import android.content.Context

class SharedPreferencesHelper {
    companion object {
        private val PREF: String = "PREF"
        val SETTINGS_SEARCH_ENGINE_SELECTION: String = "SETTINGS_SEARCH_ENGINE_SELECTION"

        fun putStringData(context: Context?, key: String, value: String) {
            context?.getSharedPreferences(PREF, Context.MODE_PRIVATE)
                    ?.edit()
                    ?.putString(key, value)
                    ?.apply()
        }

        fun getStringData(context: Context?, key: String): String? {
            return context?.getSharedPreferences(PREF, Context.MODE_PRIVATE)
                    ?.getString(key, "")
        }
    }
}