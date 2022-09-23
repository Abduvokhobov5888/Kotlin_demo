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
        var button = findViewById<Button>(R.id.button_open)
        button.text = getString(R.string.app_name)
        button.setOnClickListener{
            callLanguageActivity()
        }
    }

    fun callLanguageActivity(){
        val intent = Intent(this, LanguageActivity::class.java)
        startActivity(intent)
    }
}