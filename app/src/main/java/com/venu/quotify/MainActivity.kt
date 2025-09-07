package com.venu.quotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
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
            var isTopBarVisible by remember { mutableStateOf(true) }
            var isBottomBarVisible by remember { mutableStateOf(true) }
            val density = LocalDensity.current

            val nestedScrollConnection = remember {
                object : NestedScrollConnection {
                    override fun onPreScroll(
                        available: Offset,
                        source: NestedScrollSource,
                    ): Offset {
                        if (available.y < 0) { // Scrolling up
                            isTopBarVisible = false
                            isBottomBarVisible = false
                        }
                        if (available.y > 0) { // Scrolling down
                            isTopBarVisible = true
                            isBottomBarVisible = true
                        }
                        return Offset.Zero
                    }
                }
            }

            QuotifyTheme(darkTheme = appTheme) {
                Scaffold(
                    modifier = Modifier.nestedScroll(nestedScrollConnection),
                    topBar = {
                        AnimatedVisibility(
                            visible = isTopBarVisible,
                            enter = slideInVertically { with(density) { -40.dp.roundToPx() } },
                            exit = slideOutVertically { with(density) { -40.dp.roundToPx() } }
                        ) {
                            TopAppBar(
                                title = {
                                    AppTopAppBar(
                                        navController = navController,
                                    )
                                },
                                modifier = Modifier.statusBarsPadding(),
//                            colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                            )
                        }
                    },
                    bottomBar = {
                        AnimatedVisibility(
                            visible = isBottomBarVisible,
                            enter = slideInVertically { with(density) { 40.dp.roundToPx() } },
                            exit = slideOutVertically { with(density) { 40.dp.roundToPx() } }) {
                            AppBottomNavigationBar(navController = navController)
                        }
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