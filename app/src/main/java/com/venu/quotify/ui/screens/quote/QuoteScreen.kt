package com.venu.quotify.ui.screens.quote

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun QuoteScreen(
    quotesViewModel: QuoteViewModel,
    onNavigateToCreateQuote: () -> Unit,
) {
    val quotes by quoteViewModel.quotes.collectAsState()
}