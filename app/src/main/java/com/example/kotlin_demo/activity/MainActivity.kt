package com.example.kotlin_demo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kotlin_demo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews(){
        var b_open = findViewById<Button>(R.id.button_open)
        b_open.text = getString(R.string.app_name)

        b_open.setOnClickListener{
            callLanguageActivity()
        }
    }

    fun callLanguageActivity(){
        val intent = Intent(this, LanguageActivity::class.java)
        startActivity(intent)
    }

    fun callPrefenceActivity(){
        val intent = Intent(this, PrefenceActivity::class.java)
        startActivity(intent)
    }
}