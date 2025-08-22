package com.venu.quotify.domain.repository

import com.venu.quotify.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getQuotes(): Flow<List<Quote>>
    fun getFavouriteQuotes(): Flow<List<Quote>>
//    suspend fun addQuote(quote: Quote)
    suspend fun updateQuote(quote: Quote)
}