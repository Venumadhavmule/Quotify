package com.venu.quotify.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venu.quotify.ui.theme.QuotifyTheme


@Composable
fun QuoteCard() {
    Card(

    ) {
        Column {
            Text(
                text = "Life is what happens when you're busy making other plans",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "- Mark Twain",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuoteCardPreview() {
    QuotifyTheme {
        QuoteCard()
    }
}
