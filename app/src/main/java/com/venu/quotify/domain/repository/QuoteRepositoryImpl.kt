package com.venu.quotify.domain.repository

import com.venu.quotify.domain.model.LocalQuoteDataSource
import com.venu.quotify.domain.model.Quote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class QuoteRepositoryImpl(private val localDataSource: LocalQuoteDataSource) : QuoteRepository {

    private val allQuotes = MutableStateFlow(localDataSource.getHardCodedQuotes())

    override fun getQuotes(): Flow<List<Quote>> {
        return allQuotes.asStateFlow()
    }

    override fun getFavouriteQuotes(): Flow<List<Quote>> {
        return allQuotes.asStateFlow().map { quote ->
            quote.filter { it.isFavorite }
        }
    }

    override suspend fun updateQuote(quote: Quote) {
        val currentQuotes = allQuotes.value.toMutableList()
        val index = currentQuotes.indexOfFirst { it.id == quote.id }
        if (index != -1) {
            currentQuotes[index] = quote
            allQuotes.value = currentQuotes
        }

    }
}