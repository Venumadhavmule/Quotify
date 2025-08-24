package com.venu.quotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.venu.quotify.domain.model.LocalQuoteDataSource
import com.venu.quotify.domain.repository.QuoteRepositoryImpl
import com.venu.quotify.ui.screens.quotes.QuoteScreen
import com.venu.quotify.ui.screens.quotes.QuoteViewModel
import com.venu.quotify.ui.theme.QuotifyTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val localDataSource = LocalQuoteDataSource()
        val quoteRepository = QuoteRepositoryImpl(localDataSource)
        val quoteViewModel = QuoteViewModel(quoteRepository)

        enableEdgeToEdge()
        setContent {
            val appTheme = isSystemInDarkTheme()
            QuotifyTheme(darkTheme = appTheme) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { AppTopAppBar(if (appTheme) R.drawable.quotify_header_dark else R.drawable.quotify_header_light) },
                            modifier = Modifier.statusBarsPadding(),
//                            colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(top = 52.dp)) {
                        QuoteScreen(
                            quoteViewModel,
                            onNavigateToCreateQuote = {},
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }

            }
        }
    }
}


@Composable
fun AppTopAppBar(
    @DrawableRes icon: Int,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.quotify_app_bar_content_description),
//            modifier = Modifier.size(20.dp),
//            alignment = Alignment.Center,

        )

    }
}

@Preview
@Composable
fun TopBarPreview() {
    QuotifyTheme {
//        AppTopAppBar()
    }
}