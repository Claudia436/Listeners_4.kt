package com.example.listeners

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val button1 = findViewById<Button>(R.id.suma)
        val button2 = findViewById<Button>(R.id.resta)
        val editText = findViewById<EditText>(R.id.editText)

        button1.setOnClickListener {
            editText.clearFocus()
            var numero = textView.text.toString().toInt()
            numero += editText.text.toString().toInt()
            textView.text = numero.toString()
        }
        button2.setOnClickListener {
            var numero : Int =  Integer.valueOf(textView.text.toString())
            if (numero - editText.text.toString().toInt() >= 0)
            numero -= editText.text.toString().toInt()
            textView.text = numero.toString()
        }
        editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                button1.setBackgroundColor(Color.GREEN)
                button2.setBackgroundColor(Color.GREEN)
            } else {
                button1.setBackgroundColor(Color.BLUE)
                button2.setBackgroundColor(Color.BLUE)
            }
        }
    }
}
