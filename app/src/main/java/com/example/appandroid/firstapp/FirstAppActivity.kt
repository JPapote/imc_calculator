package com.example.appandroid.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.appandroid.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val text = findViewById<AppCompatEditText>(R.id.eName)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)

        btnStart.setOnClickListener {
            val text = text.text.toString()

            if(text.isNotEmpty()){
                val intert = Intent(this, ResultActivity::class.java)
                intert.putExtra("EXTRA_NAME", text)
                startActivity(intert)
            }
        }
    }
}