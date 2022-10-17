package com.example.kotlin_demo

import android.app.Application
import android.content.res.Configuration
import com.example.kotlin_demo.managers.LocaleManager

class MyApplication: Application() {

    companion object{
        var localeManager: LocaleManager? = null
    }

    override fun onCreate() {
        super.onCreate()
        localeManager = LocaleManager(this)
        localeManager!!.setLocale(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeManager!!.setLocale(this)
    }
}