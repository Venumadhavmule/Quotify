package com.venu.quotify.domain.model

class LocalQuoteDataSource {
    fun getHardCodedQuotes(): List<Quote> {
        return listOf(
            Quote(
                id = 1,
                text = "The only way to do great work is to love what you do.",
                author = "Steve Jobs",
                isFavorite = false
            ),
            Quote(
                id = 2,
                text = "Success is not final, failure is not fatal: it is the courage to continue that counts.",
                author = "Winston Churchill",
                isFavorite = false
            ),
            Quote(
                id = 3,
                text = "The future belongs to those who believe in the beauty of their dreams.",
                author = "Eleanor Roosevelt",
                isFavorite = false
            ),
            Quote(
                id = 4,
                text = "It is never too late to be what you might have been.",
                author = "George Eliot",
                isFavorite = false
            )
        )
    }
}