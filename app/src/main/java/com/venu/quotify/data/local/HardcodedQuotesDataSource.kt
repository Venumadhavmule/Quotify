package com.venu.quotify.data.local


import com.venu.quotify.domain.model.Quote

object HardcodedQuotesDataSource {
    val categories = listOf("Motivation", "Love", "Success", "Happiness")
    val quotes: List<Quote> = listOf(

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

//        Quote(
//            1,
//            "Dream big.",
//            "Anonymous",
//            false
//        ),
//
//        Quote(
//            2,
//            "Life is short.",
//            "Anonymous",
//            false
//        ),
//
//        Quote(
//            stableId("Success is getting what you want.", "Anonymous"),
//            "Success is getting what you want.",
//            "Anonymous",
//            "Success"
//        ),
//        Quote(
//            stableId(
//                "Happiness is not something ready made. It comes from your own actions.",
//                "Anonymous"
//            ),
//            "Happiness is not something ready made. It comes from your own actions.",
//            "Anonymous",
//            "Happiness"
//        ),
//        Quote(stableId("Love is a choice.", "Anonymous"), "Love is a choice.", "Anonymous", "Love"),
//        Quote(
//            stableId("The best way to predict the future is to create it.", "Peter Drucker"),
//            "The best way to predict the future is to create it.",
//            "Peter Drucker",
//            "Motivation"
//        ),
//        Quote(
//            stableId("The only way to do great work is to love what you do.", "Steve Jobs"),
//            "The only way to do great work is to love what you do.",
//            "Steve Jobs",
//            "Motivation"
//        ),
//        Quote(
//            stableId("Happiness is a direction, not a place.", "Sydney J. Harris"),
//            "Happiness is a direction, not a place.",
//            "Sydney J. Harris",
//            "Happiness"
//        ),
//        Quote(
//            stableId("Love all, trust a few.", "William Shakespeare"),
//            "Love all, trust a few.",
//            "William Shakespeare",
//            "Love"
//        ),
//        Quote(
//            stableId("Believe you can and you're halfway there.", "Theodore Roosevelt"),
//            "Believe you can and you're halfway there.",
//            "Theodore Roosevelt",
//            "Motivation"
//        ),
    )
}