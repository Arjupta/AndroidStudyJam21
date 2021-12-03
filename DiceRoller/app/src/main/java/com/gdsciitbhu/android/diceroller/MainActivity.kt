package com.gdsciitbhu.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceImage = findViewById<ImageView>(R.id.dice_image)
        val rollButton = findViewById<Button>(R.id.btn_roll)

        val diceImages = listOf(
            R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6,
        )

        rollButton.setOnClickListener {
            diceImage.setImageResource(diceImages.random())
        }
    }
}