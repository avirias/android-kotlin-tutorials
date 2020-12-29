package com.arjun1194.firebasenotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            println("Hi")
        }
    }
}