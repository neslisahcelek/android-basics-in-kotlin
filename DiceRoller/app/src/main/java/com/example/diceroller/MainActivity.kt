package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { /** **/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        rollDice()
    }
    private fun rollDice() {
        val myFirstDice = Dice(6)
        val rollResult = myFirstDice.roll()
        val rollResult2 = myFirstDice.roll()

        // Find the ImageView in the layout
        var diceImage: ImageView = findViewById(R.id.imageView)
        var diceImage2: ImageView = findViewById(R.id.imageView2)

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(getDrawableResource(rollResult))
        diceImage2.setImageResource(getDrawableResource(rollResult2))

        // Update the content description
        diceImage.contentDescription = rollResult.toString()
        diceImage2.contentDescription = rollResult.toString()
    }
    fun getDrawableResource(rollResult:Int):Int{
        val result = when(rollResult){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> { R.drawable.dice6 }
        }
        return result
    }

    private fun rollLuckyNumber(){
        val myDice = Dice(6)
        val rollResult = myDice.roll()
        val luckyNumber = 4
        //2 methods to compare result and lucky number
        if(rollResult == luckyNumber){ //first method
            println("You win! Lucky number was $luckyNumber :)")
        }
        else
            println("Try again :(")

        when(rollResult){ //second method
            luckyNumber -> println("You win! Lucky number was $luckyNumber :)")
            else -> println("Try again :(")
        }
    }

}
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}