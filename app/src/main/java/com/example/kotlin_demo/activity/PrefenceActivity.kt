package com.example.kotlin_demo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.kotlin_demo.R
import com.example.kotlin_demo.managers.PrefsManager

class PrefenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefence)

        initViews()
    }

    fun initViews(){
        var et_email = findViewById<EditText>(R.id.et_email)
        var b_save = findViewById<Button>(R.id.b_save)
        var b_load = findViewById<Button>(R.id.b_load)

        b_save.setOnClickListener{
            val email = et_email.text.toString().trim()
            PrefsManager.getInstance(this)!!.saveData("email",email)
        }

        b_load.setOnClickListener {
            val email = PrefsManager.getInstance(this)!!.loadData("email")
            Log.d("PrefenceActivity", email!!)
        }

    }


    }