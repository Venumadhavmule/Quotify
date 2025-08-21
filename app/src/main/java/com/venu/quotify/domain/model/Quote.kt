package com.venu.quotify.domain.model

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    var isFavorite: Boolean = false, // isFavorite can be a state for local changes
)