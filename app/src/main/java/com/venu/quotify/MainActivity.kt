package com.venu.quotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.venu.quotify.domain.model.LocalQuoteDataSource
import com.venu.quotify.domain.repository.QuoteRepositoryImpl
import com.venu.quotify.ui.components.AppTopAppBar
import com.venu.quotify.ui.navigation.AppBottomNavigationBar
import com.venu.quotify.ui.navigation.AppNavHost
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
                            title = {
                                AppTopAppBar(
                                    navController = navController,
                                )
                            },
                            modifier = Modifier.statusBarsPadding(),
//                            colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        )
                    },
                    bottomBar = {
                        AppBottomNavigationBar(navController = navController)
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        AppNavHost(navController = navController, quoteViewModel)
                    }
                }
            }
        }
    }
}