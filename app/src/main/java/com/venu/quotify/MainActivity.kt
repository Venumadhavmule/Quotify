package com.venu.quotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

import com.venu.quotify.domain.model.LocalQuoteDataSource
import com.venu.quotify.domain.repository.QuoteRepositoryImpl
import com.venu.quotify.ui.components.AppTopAppBar
import com.venu.quotify.ui.components.BottomNavBar
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
            val navController = rememberNavController()
            val appTheme = isSystemInDarkTheme()
            QuotifyTheme(darkTheme = appTheme) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { AppTopAppBar(if (appTheme) R.drawable.quotify_header_dark else R.drawable.quotify_header_light) },
                            modifier = Modifier.statusBarsPadding(),
//                            colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        )
                    },
                    bottomBar = {
                        NavigationBar{
                            BottomNavBar(navController = navController)
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(top = 52.dp, bottom = 60.dp)) {
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