package com.example.kotlin_demo.managers

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.LocaleList
import android.preference.PreferenceManager
import android.util.Log
import androidx.annotation.RequiresApi
import org.intellij.lang.annotations.Language
import java.util.Locale
import kotlin.math.log

class LocaleManager(context: Context) {
    private val prefs: SharedPreferences

    companion object{
        const val LANGUAGE_ENGLISH = "en"
        const val LANGUAGE_RUSSIA = "ru"
        const val LANGUAGE_UZBEK = "uz"
        const val LANGUAGE_KOREA = "ko"
        const val LANGUAGE_JAPAN = "ja"
        const val LANGUAGE_CHINA = "zh"
        private const val LANGUAGE_KEY = "language key"

        fun getLocal(res: Resources): Locale{
            val config = res.configuration
            return if (isAtLeastVersion(Build.VERSION_CODES.N)) config.locales[0] else config.locale
        }

        fun isAtLeastVersion(version: Int): Boolean{
            return VERSION.SDK_INT >= version
        }
    }

    init {
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }

    val language: String?
    get() = prefs.getString(LANGUAGE_KEY, LANGUAGE_ENGLISH)

    fun setLocale(c: Context): Context{
        return update(c, language)
    }

    private fun update(c: Context, language: String?): Context{
        updateResources(c, language)
        val appContext = c.applicationContext
        if (c != appContext){
            updateResources(appContext, language)
        }
        return appContext
    }

    fun setNewLocale(c: Context, language: String?) {
        presistLanguage(language!!)
        update(c, language)
    }

    @SuppressLint("ApplySharedPref")
    private fun presistLanguage(language: String){
        prefs.edit().putString(LANGUAGE_KEY, language).commit()
    }

    private fun updateResources(context: Context, language: String?){
        val locale = Locale(language)
        Locale.setDefault(locale)
        val res = context.resources
        val config = Configuration(res.configuration)
        if (isAtLeastVersion(VERSION_CODES.N)){
          //  Log.d("@@@", "VERSION_CODES.N")
            setLocaleForApi24(config, locale)
        }
        else if (isAtLeastVersion((Build.VERSION_CODES.JELLY_BEAN_MR1))){
            config.setLocale(locale)
        }
        else{
          //  Log.d("@@@","VERSION_CODES>>")
            config.locale = locale
        }
        res.updateConfiguration(config, res.displayMetrics)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun setLocaleForApi24(config: Configuration, target: Locale){
        val set: MutableSet<Locale> = LinkedHashSet()
        set.add(target)
        val all = LocaleList.getDefault()
        for (i in 0 until all.size()){
            set.add(all[i])
        }
        val locales = set.toTypedArray()
       // config.setLocale(LocaleList(*locales))
    }


}