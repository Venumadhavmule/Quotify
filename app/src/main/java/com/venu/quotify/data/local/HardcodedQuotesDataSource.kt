package com.venu.quotify.data.local

import com.venu.quotify.domain.Quote
import com.venu.quotify.domain.stableId

object HardcodedQuotesDataSource {
    val categories = listOf("Motivation", "Love", "Success", "Happiness")
    val quotes: List<Quote> = listOf(
        Quote(
            stableId("Dream big.", "Anon"),
            "Dream big.",
            "Anon",
            "Motivation"
        ),

        Quote(
            stableId("Life is short.", "Anonymous"),
            "Life is short.",
            "Anonymous",
            "Motivation"
        ),

        Quote(
            stableId("Success is getting what you want.", "Anonymous"),
            "Success is getting what you want.",
            "Anonymous",
            "Success"
        ),
        Quote(
            stableId(
                "Happiness is not something ready made. It comes from your own actions.",
                "Anonymous"
            ),
            "Happiness is not something ready made. It comes from your own actions.",
            "Anonymous",
            "Happiness"
        ),
        Quote(stableId("Love is a choice.", "Anonymous"), "Love is a choice.", "Anonymous", "Love"),
        Quote(
            stableId("The best way to predict the future is to create it.", "Peter Drucker"),
            "The best way to predict the future is to create it.",
            "Peter Drucker",
            "Motivation"
        ),
        Quote(
            stableId("The only way to do great work is to love what you do.", "Steve Jobs"),
            "The only way to do great work is to love what you do.",
            "Steve Jobs",
            "Motivation"
        ),
        Quote(
            stableId("Happiness is a direction, not a place.", "Sydney J. Harris"),
            "Happiness is a direction, not a place.",
            "Sydney J. Harris",
            "Happiness"
        ),
        Quote(
            stableId("Love all, trust a few.", "William Shakespeare"),
            "Love all, trust a few.",
            "William Shakespeare",
            "Love"
        ),
        Quote(
            stableId("Believe you can and you're halfway there.", "Theodore Roosevelt"),
            "Believe you can and you're halfway there.",
            "Theodore Roosevelt",
            "Motivation"
        ),
    )
}