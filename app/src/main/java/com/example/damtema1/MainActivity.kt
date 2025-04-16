package com.example.damtema1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.damtema1.R

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var historyText: EditText

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // editText views
        inputText = findViewById(R.id.inputText)
        historyText = findViewById(R.id.historyText)

        // id butoane
        val buttonMap = mapOf(
            R.id.button1 to "1", R.id.button2 to "2", R.id.button3 to "3", R.id.button4 to "4",
            R.id.button5 to "5", R.id.button6 to "6", R.id.button7 to "7", R.id.button8 to "8",
            R.id.button9 to "9", R.id.buttonA to "A", R.id.buttonB to "B", R.id.buttonC to "C",
            R.id.buttonD to "D", R.id.buttonE to "E", R.id.buttonF to "F", R.id.button0 to "0"
        )

        // nr buttons
        for ((buttonId, value) in buttonMap) {
            val button = findViewById<Button>(buttonId)
            if (button != null) {
                button.setOnClickListener {
                    inputText.append(value) // scrie
                }
            } else {
                Log.e("MainActivity", "Button with ID $buttonId not found.")
            }
        }

        // OK button
        findViewById<Button>(R.id.buttonOK)?.setOnClickListener {
            val input = inputText.text.toString()
            if (input.isNotBlank()) {
                val newHistory = historyText.text.toString() + "\n" + input
                historyText.setText(newHistory.trim()) // adauga la istoric
                inputText.setText("") // sterge input
            }
        }

        // BACK button
        findViewById<Button>(R.id.buttonBack)?.setOnClickListener {
            val text = inputText.text.toString()
            if (text.isNotEmpty()) {
                inputText.setText(text.dropLast(1)) // sterge ultimul caracter
            }
        }
    }
}
