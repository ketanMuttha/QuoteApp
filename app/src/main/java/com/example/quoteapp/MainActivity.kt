package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.quoteapp.presentation.theme.QuoteAppTheme
import com.example.quoteapp.presentation.ui.navigation.QuotesScreenNavHost
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteAppTheme {
                QuotesScreenNavHost()
            }
        }
    }
}