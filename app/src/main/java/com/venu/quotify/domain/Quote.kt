package com.venu.quotify.domain

data class Quote(
    val id: String,
    val text: String,
    val author: String?,
    val category: String?,
)

fun stableId(text: String, author: String?): String =
    (text.trim() + "|" + (author?.trim() ?: "")).hashCode().toString()