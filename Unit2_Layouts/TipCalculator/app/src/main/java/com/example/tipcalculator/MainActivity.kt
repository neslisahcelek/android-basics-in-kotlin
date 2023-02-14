package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.text.NumberFormat.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }
    fun calculateTip(){
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()

        val selectedID = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedID){
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if(roundUp){
            tip = ceil(tip)
        }
        val formattedTip = getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)



    }
}