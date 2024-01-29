package com.example.localization

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.Locale
import android.view.View

class MainActivity : AppCompatActivity() {

    private var defaultLanguage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greetingTextView = findViewById<TextView>(R.id.greetingTextView)
        val languageSwitch = findViewById<SwitchMaterial>(R.id.languageSwitch)

        // Get the default language
        defaultLanguage = Locale.getDefault().language

        // Set greeting message
        val greetingMessage = getGreetingMessage()
        greetingTextView.text = greetingMessage

        // Show switch button only if default language is not English
        languageSwitch.visibility = if (defaultLanguage != "en") View.VISIBLE else View.GONE

        // Set up a listener for the switch button
        languageSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                changeAppLanguage("en") // Change language to English
            } else {
                changeAppLanguage(defaultLanguage) // Change language back to default
            }
            // Update the greeting message after language change
            greetingTextView.text = getGreetingMessage()
        }
    }

    private fun getGreetingMessage(): String {
        val defaultLocale = Locale.getDefault()
        return when (defaultLocale.language) {
            "ar" -> getString(R.string.greeting_message_arabic) // Arabic
            "es" -> getString(R.string.greeting_message_spanish) // Spanish
            "fr" -> getString(R.string.greeting_message_french) // French
            else -> getString(R.string.greeting_message) // Default to English
        }
    }

    private fun changeAppLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = resources
        val configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}
