package br.com.cursoandroid.www.whatsappclone.util

import android.content.Context

class SharedPreferencesUtil {

    companion object {
        private val fileName = "whats.prefereces"
        fun putValue(context: Context,key: String, value: Any) {
           val sharedEditor = context.getSharedPreferences(fileName,0).edit()
        }
    }
}