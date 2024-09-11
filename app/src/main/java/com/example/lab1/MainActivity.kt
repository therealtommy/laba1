package com.example.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val editTextNumber3 = findViewById<EditText>(R.id.editTextNumber3)
        val editTextText = findViewById<EditText>(R.id.editTextText)
        val buttonCalculate = findViewById<Button>(R.id.button)

        buttonCalculate.setOnClickListener{
        val number1 = editTextNumber.text.toString().toDoubleOrNull()
        val number2 = editTextNumber2.text.toString().toDoubleOrNull()
        val number3 = editTextNumber3.text.toString().toDoubleOrNull()
        val symbol = editTextText.text.toString()

        if (number1 != null && number2 != null && number3 != null) {
            when (symbol) {
                "a" -> {
                    val average = (number1 + number2 + number3) / 3
                    Toast.makeText(this, "Среднее арифметическое: $average", Toast.LENGTH_LONG).show()
                }
                "g" -> {
                    val geometricMean = (number1 * number2 * number3).pow(1.0 / 3.0)
                    Toast.makeText(this, "Среднее геометрическое: $geometricMean", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "Ошибка: неверный символ", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            Toast.makeText(this, "Ошибка: введите все числа", Toast.LENGTH_LONG).show()
        }
    }
    }
}
