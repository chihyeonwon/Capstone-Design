package com.wonchihyeon.giveback.utils

import android.content.SharedPreferences


class PreferenceUtil(context: android.content.Context) {
    private val preferences: SharedPreferences =
        context.getSharedPreferences("prefs_name", android.content.Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String): String {
        return preferences.getString(key, defValue).toString()
    }

    fun setString(key: String, defValue: String) {
        preferences.edit().putString(key, defValue).apply()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return preferences.getBoolean(key, defValue)
    }

    fun setBoolean(key: String, defValue: Boolean) {
        preferences.edit().putBoolean(key, defValue).apply()
    }
}