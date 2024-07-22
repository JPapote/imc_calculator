package com.example.appandroid.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.appandroid.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val resul = findViewById<TextView>(R.id.tvResult)
        val text:String = intent.extras?.getString("EXTRA_NAME").orEmpty();
        println(text)
        resul.text = "Hola $text"
    }
}