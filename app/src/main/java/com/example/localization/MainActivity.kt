package com.example.localization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.localization.ui.theme.LocalizationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalizationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.hello))
        Text(text = stringResource(R.string.welcome_title))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() = LocalizationTheme { Greeting() }
@Preview(showBackground = true, locale = "ar")
@Composable
fun ArabicGreetingPreview() = LocalizationTheme { Greeting() }
@Preview(showBackground = true, locale = "hi")
@Composable
fun HindiGreetingPreview() = LocalizationTheme { Greeting() }
@Preview(showBackground = true, locale = "es")
@Composable
fun SpanishGreetingPreview() = LocalizationTheme { Greeting() }