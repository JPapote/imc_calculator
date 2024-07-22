package com.example.appandroid.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.appandroid.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonSalute = findViewById<Button>(R.id.btnSaludarApp)
        buttonSalute.setOnClickListener { navigateToSaluteApp() }

        val buttonImc = findViewById<Button>(R.id.btnImc)
        buttonImc.setOnClickListener{ navigateToImcCalculatorActivity() }
    }
        private fun navigateToSaluteApp(){
            val intent = Intent(this, FirstAppActivity::class.java)
            startActivity(intent)
        }

        private fun navigateToImcCalculatorActivity(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }


}