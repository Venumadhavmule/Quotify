package com.venu.quotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.venu.quotify.domain.model.LocalQuoteDataSource
import com.venu.quotify.domain.repository.QuoteRepositoryImpl
import com.venu.quotify.ui.screens.quotes.QuoteScreen
import com.venu.quotify.ui.screens.quotes.QuoteViewModel
import com.venu.quotify.ui.theme.QuotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val localDataSource = LocalQuoteDataSource()
        val quoteRepository = QuoteRepositoryImpl(localDataSource)
        val quoteViewModel = QuoteViewModel(quoteRepository)
        enableEdgeToEdge()
        setContent {
            QuotifyTheme {
                QuoteScreen(quoteViewModel, onNavigateToCreateQuote = {})
            }
        }
    }
}