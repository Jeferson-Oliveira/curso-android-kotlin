package br.com.cursoandroid.www.whatsappclone.util

import android.content.Context

class SharedPreferencesUtil {

    companion object {
        private val fileName = "whats.prefereces"

        fun putValue(context: Context,key: String, value: String) {
            val sharedEditor = context.getSharedPreferences(fileName,0).edit()
            sharedEditor.putString(key,value)
            sharedEditor.apply()
        }

        fun getValue(context: Context, key: String): String {
            return context.getSharedPreferences(fileName,0).getString(key,"")
        }
    }
}