package com.example.appandroid.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.appandroid.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelect: Boolean = true;
    private var isFemaleSelect: Boolean = false;

    private lateinit var malebtn: CardView;
    private lateinit var femalebtn: CardView;
    private lateinit var tvHeight: TextView;
    private lateinit var rsHeight: RangeSlider;
    private lateinit var tvWeight:TextView;
    private lateinit var btnSubtractWeight:FloatingActionButton;
    private lateinit var btnPlusWeight:FloatingActionButton;
    private lateinit var tvAge:TextView;
    private lateinit var btnSubtractAge:FloatingActionButton;
    private lateinit var btnPlusAge:FloatingActionButton;
    private lateinit var btnCalculate:Button;

    private var currentWeight:Int  = 60;
    private var currentAge:Int = 33;
    private var currentHeight:Int = 120

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        this.initComponents()
        this.initListiner()
        this.initUI()
    }

    private fun initComponents() {
        this.malebtn = findViewById(R.id.viewMale)
        this.femalebtn = findViewById(R.id.viewFemale)
        this.tvHeight = findViewById(R.id.tvHeight)
        this.rsHeight = findViewById(R.id.rsHeight)
        this.tvWeight = findViewById(R.id.tvWeight)
        this.btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        this.btnPlusWeight = findViewById(R.id.btnPlusWeight)
        this.tvAge = findViewById(R.id.tvAge)
        this.btnSubtractAge = findViewById(R.id.btnSubtractAge)
        this.btnPlusAge = findViewById(R.id.btnPlusAge)
        this.btnCalculate = findViewById(R.id.btnCaculate)
    }

    private fun initListiner() {
        this.malebtn.setOnClickListener {
            changeGenderColor()
            setGenderColor()
        }
        this.femalebtn.setOnClickListener {
            changeGenderColor()
            setGenderColor()
        }

        this.rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            this.currentHeight =  df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }

        this.btnSubtractWeight.setOnClickListener{
            this.currentWeight -= 1;
            this.setWeight()
        }

        this.btnPlusWeight.setOnClickListener{
            this.currentWeight += 1;
            this.setWeight()
        }

        this.btnSubtractAge.setOnClickListener{
            this.currentAge -= 1;
            this.setAge();
        }

        this.btnPlusAge.setOnClickListener{
            this.currentAge += 1;
            this.setAge();
        }

        this.btnCalculate.setOnClickListener {
            this.calculate();
        }

    }

    private fun navigate(result:Double){
        val intert = Intent(this, ResultImcActivity::class.java)
        intert.putExtra(IMC_KEY, result)
        startActivity(intert)
    }

    private fun calculate(){
        val df = DecimalFormat("#.##");
        val imc = this.currentWeight / (currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100);
        val result = df.format(imc).toDouble();
        this.navigate(result);
    }

    private fun changeGenderColor() {
        this.isMaleSelect = !this.isMaleSelect;
        this.isFemaleSelect = !this.isFemaleSelect;
    }

    private fun setGenderColor() {
        this.malebtn.setCardBackgroundColor(getBackgroundColor(isMaleSelect))
        this.femalebtn.setCardBackgroundColor(getBackgroundColor(isFemaleSelect))
    }

    private fun getBackgroundColor(isSelectComponent: Boolean): Int {

        val colorReference = if (isSelectComponent) {
            R.color.background_component_select
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun setWeight(){
        this.tvWeight.text = this.currentWeight.toString();
    }

    private fun setAge(){
        this.tvAge.text = this.currentAge.toString();
    }

    private fun initUI() {
        setGenderColor();
        setWeight();
        setAge();
    }
}