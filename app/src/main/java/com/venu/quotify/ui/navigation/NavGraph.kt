package com.venu.quotify.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.venu.quotify.ui.screens.quotes.QuoteScreen
import com.venu.quotify.ui.screens.quotes.QuoteViewModel

enum class Routes(val route: String) {
    QuoteScreen("quote_screen"),
    FavouriteScreen("favourite_screen"),
    CreateQuoteScreen("create_quote_screen"),
    ProfileScreen("profile_screen")
}

sealed class Screen(val route: String, val title: String? = null, val icon: ImageVector? = null) {
    object QuoteScreen : Screen(
        Routes.QuoteScreen.route,
        "Home",
        Icons.Rounded.Home
    )

    object FavouriteScreen : Screen(
        Routes.FavouriteScreen.route,
        "Favourites",
        Icons.Rounded.Favorite
    )

    object CreateQuoteScreen : Screen(
        Routes.CreateQuoteScreen.route,
        "Create",
        Icons.Rounded.Add
    )

    object ProfileScreen : Screen(
        Routes.ProfileScreen.route,
        "Profile",
        Icons.Rounded.AccountCircle
    )
}

@Composable
fun NavGraph(navController: NavHostController) {
    val quoteViewModel: QuoteViewModel = viewModel()
    NavHost(navController, startDestination = Screen.QuoteScreen.route) {
        composable(Screen.QuoteScreen.route) {
            QuoteScreen(quoteViewModel, {})
        }
        composable(Screen.FavouriteScreen.route) {
            Screen.FavouriteScreen
        }

        composable(Screen.ProfileScreen.route) {
            Screen.ProfileScreen
        }
    }
}