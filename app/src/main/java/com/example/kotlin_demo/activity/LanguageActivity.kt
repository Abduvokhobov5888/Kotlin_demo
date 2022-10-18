package com.example.kotlin_demo.activity

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_demo.MyApplication
import com.example.kotlin_demo.R
import com.example.kotlin_demo.managers.LocaleManager
import java.util.*

class LanguageActivity: AppCompatActivity() {
        lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        initViews()
    }

    fun initViews(){
        context = this;
        var b_english = findViewById<Button>(R.id.b_english)
        var b_russian = findViewById<Button>(R.id.b_russian)
        var b_uzbek = findViewById<Button>(R.id.b_uzbek)
        var b_japan = findViewById<Button>(R.id.b_japan)
        var b_korea = findViewById<Button>(R.id.b_korea)
        var b_china = findViewById<Button>(R.id.b_china)

        b_english.setOnClickListener{
            MyApplication.localeManager!!.setNewLocale(context,LocaleManager.LANGUAGE_ENGLISH)
            finish()
           // setLocale("en")
        }

        b_russian.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context ,LocaleManager.LANGUAGE_RUSSIA)
            finish()
        //setLocale("ru")
        }

        b_uzbek.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context ,LocaleManager.LANGUAGE_UZBEK)
            finish()
        //setLocale("uz")
        }

        b_japan.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context ,LocaleManager.LANGUAGE_JAPAN)
            finish()
            //setLocale("ja")
        }

        b_korea.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context ,LocaleManager.LANGUAGE_KOREA)
            finish()
          //  setLocale("ko")
        }

        b_china.setOnClickListener {
            MyApplication.localeManager!!.setNewLocale(context ,LocaleManager.LANGUAGE_CHINA)
            finish()
           // setLocale("zh")
        }
    }


    fun setLocale(lan: String){
        val locale = Locale(lan)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        finish()
    }
}