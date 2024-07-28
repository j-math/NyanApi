package com.jma.nyanapi.util

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceNyanApi (context: Context) {
    private val prefFile = SharedPreferenceNyanApi::class.java.name
    private val preferences: SharedPreferences = context.getSharedPreferences(prefFile, 0)

    private val keyNanoSession = "nano_id_session"
    private val keyNanoAnonymous = "nano_id_anonymous"
    private val keySessionTime = "session_time"

    var nanoIDSession: String?
        get() = preferences.getString(keyNanoSession, "")
        set(value) = preferences.edit().putString(keyNanoSession, value).apply()

    var nanoIDAnonymous: String?
        get() = preferences.getString(keyNanoAnonymous, "")
        set(value) = preferences.edit().putString(keyNanoAnonymous, value).apply()

    var sessionTime: Long
        get() = preferences.getLong(keySessionTime, 0)
        set(value) = preferences.edit().putLong(keySessionTime, value).apply()

    fun clear(context: Context) {
        context.getSharedPreferences(prefFile, Context.MODE_PRIVATE).edit().clear()
            .apply()
    }
}