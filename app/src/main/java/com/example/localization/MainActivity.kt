package com.example.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingMessage = getGreetingMessage()

        val greetingTextView = findViewById<TextView>(R.id.greetingTextView)
        greetingTextView.text = greetingMessage
    }

    private fun getGreetingMessage(): String {
        val defaultLocale = Locale.getDefault()
        return when (defaultLocale.language) {
            "ar" -> getString(R.string.greeting_message_arabic) // Corrected to "ar" for Arabic

            // Add more cases for other languages as needed
            else -> getString(R.string.greeting_message) // Default to English
        }
    }
}
