package com.venu.quotify.ui.screens.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venu.quotify.domain.model.Quote
import com.venu.quotify.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val quoteRepository: QuoteRepository,
) : ViewModel() {
    val quotes: StateFlow<List<Quote>> = quoteRepository.getQuotes().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000), emptyList()
    )

    fun toggleFavorite(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.updateQuote(quote.copy(isFavorite = !quote.isFavorite))
        }
    }
}