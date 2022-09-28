package com.example.kotlin_demo.activity

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_demo.R
import java.util.*

class LanguageActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        initViews()
    }

    fun initViews(){
        var b_english = findViewById<Button>(R.id.b_english)
        var b_russian = findViewById<Button>(R.id.b_russian)
        var b_uzbek = findViewById<Button>(R.id.b_uzbek)
        var b_japan = findViewById<Button>(R.id.b_japan)
        var b_korea = findViewById<Button>(R.id.b_korea)
        var b_china = findViewById<Button>(R.id.b_china)

        b_english.setOnClickListener{
            setLocale("en")
        }

        b_russian.setOnClickListener {
            setLocale("ru")
        }

        b_uzbek.setOnClickListener {
            setLocale("uz")
        }

        b_japan.setOnClickListener {
            setLocale("jp")
        }

        b_korea.setOnClickListener {
            setLocale("kr")
        }

        b_china.setOnClickListener {
            setLocale("cn")
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