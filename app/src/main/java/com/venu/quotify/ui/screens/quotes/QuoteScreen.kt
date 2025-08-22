package com.venu.quotify.ui.screens.quotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.venu.quotify.ui.components.QuoteCard
import com.venu.quotify.ui.theme.QuotifyTheme

@Composable
fun QuoteScreen(
    quotesViewModel: QuoteViewModel,
    onNavigateToCreateQuote: () -> Unit,
) {
    val quotes by quotesViewModel.quotes.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToCreateQuote) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Create new quote"
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(quotes) { quote ->
                QuoteCard(quote = quote, onFavouriteClicked = {
                })
            }
        }
    }
}

@Preview
@Composable
fun QuoteScreenPreview() {
    QuotifyTheme {
//        QuoteScreen(onNavigateToCreateQuote = {})

    }
}