package com.venu.quotify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.venu.quotify.ui.screens.quotes.QuoteScreen
import com.venu.quotify.ui.screens.quotes.QuoteViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    quoteViewModel: QuoteViewModel,
) {
    NavHost(navController = navController, startDestination = BottomNavItems.QuoteScreen.route) {
        composable(BottomNavItems.QuoteScreen.route) {
            QuoteScreen(quoteViewModel = quoteViewModel, onNavigateToCreateQuote = {
                navController.navigate(BottomNavItems.QuoteScreen.route)
            })
        }

        composable(BottomNavItems.FavouriteScreen.route) { }

        composable(route = BottomNavItems.CreateQuoteScreen.route) { }

        composable(route = BottomNavItems.ProfileScreen.route) { }
    }
}
