package com.gdsciitbhu.android.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        result = findViewById(R.id.result)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnSubtract = findViewById<Button>(R.id.btn_subtract)
        val btnMultiply = findViewById<Button>(R.id.btn_multiply)
        val btnDivide = findViewById<Button>(R.id.btn_divide)

        btnAdd.setOnClickListener {
            getResult('+')
        }

        btnSubtract.setOnClickListener {
            getResult('-')
        }

        btnMultiply.setOnClickListener {
            getResult('*')
        }

        btnDivide.setOnClickListener {
            getResult('/')
        }
    }

    private fun getResult(operator: Char) {
        val a = number1.text.toString().toInt()
        val b = number2.text.toString().toInt()
        if (b == 0 && operator == '/') {
            result.text = "Can't divide by zero"
            return
        }
        val answer = when (operator) {
            '+' -> "$a + $b = ${a + b}"
            '-' -> "$a - $b = ${a - b}"
            '*' -> "$a * $b = ${a * b}"
            '/' -> "$a / $b = ${a / b}"
            else -> ""
        }
        result.text = answer
    }
}