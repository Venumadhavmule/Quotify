package com.venu.quotify.domain.model

class LocalQuoteDataSource {
    fun getHardCodedQuotes(): List<Quote> {
        return listOf(
            Quote(
                id = 1,
                text = "The only way to do great work is to love what you do.",
                author = "Steve Jobs",
                isFavorite = true
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
                isFavorite = true
            ),
            Quote(
                id = 5,
                text = "Dream big.",
                author = "Zig Ziglar",
                false
            ),

            Quote(
                id = 6,
                text = "Life is short.",
                author = "Mark Twain",
                isFavorite = false
            ),

            Quote(
                id = 7,
                text = "Success is getting what you want.",
                author = "Dale Carnegie",
//            category = "Success",
                isFavorite = false
            ),
            Quote(
                id = 8,
                text = "Happiness is not something ready made. It comes from your own actions.",
                author = "Dalai Lama XIV    ",
//            category = "Happiness",
                isFavorite = true
            ),
            Quote(
                id = 9,
                text = "Love is a choice.",
                author = "Matthew Kelly",
//            category = "Love",
                isFavorite = false
            ),
            Quote(
                id = 10,
                text = "The best way to predict the future is to create it.",
                author = "Peter Drucker",
//            category = "Motivation",
                isFavorite = false
            ),
            Quote(
                id = 11,
                text = "The only way to do great work is to love what you do.",
                author = "Steve Jobs",
//            category = "Motivation",
                isFavorite = false
            ),
            Quote(
                id = 12,
                text = "Happiness is a direction, not a place.",
                author = "Sydney J. Harris",
//            category = "Happiness",
                isFavorite = false
            ),
            Quote(
                id = 13,
                text = "Love all, trust a few.",
                author = "William Shakespeare",
//            category = "Love",
                isFavorite = false
            ),
            Quote(
                id = 14,
                text = "Believe you can and you're halfway there.",
                author = "Theodore Roosevelt",
//            category = "Motivation",
                isFavorite = false
            )

        )
    }
}