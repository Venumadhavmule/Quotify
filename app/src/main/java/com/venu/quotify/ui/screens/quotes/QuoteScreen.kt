package com.venu.quotify.ui.screens.quotes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.venu.quotify.ui.components.QuoteCard

@Composable
fun QuoteScreen(
    quoteViewModel: QuoteViewModel,
    onNavigateToCreateQuote: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val quotes by quoteViewModel.quotes.collectAsState()
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(quotes) { quote ->
                QuoteCard(quote = quote, onFavouriteClicked = {
                    // Implement favourite clicked logic
                })
            }
        }
    }
}