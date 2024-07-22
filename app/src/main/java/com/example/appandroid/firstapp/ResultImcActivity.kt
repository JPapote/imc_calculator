package com.example.appandroid.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.appandroid.R
import com.example.appandroid.firstapp.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {

    private lateinit var bntRecalcutate:Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        showResult()
        initComponents()
        listenerComponents()

    }

    private fun initComponents(){
        this.bntRecalcutate = findViewById<Button>(R.id.re_calculate)
    }

    private fun showResult(){
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0;
        findViewById<TextView>(R.id.tvDescription).text = result.toString();
    }

    private fun listenerComponents(){
        this.bntRecalcutate.setOnClickListener {
            navigate()
        }
    }

    private fun navigate () {
        val intert = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intert)
    }
}