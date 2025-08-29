package com.venu.quotify.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItems.QuoteScreen,
        BottomNavItems.FavouriteScreen,
        BottomNavItems.CreateQuoteScreen,
        BottomNavItems.ProfileScreen
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == item.route) {
                            item.selectedIcon
                        } else {
                            item.unSelectedIcon
                        },
                        contentDescription = item.title
                    )
                }, label = {
                    Text(
                        text = item.title,
                        fontWeight = if (currentRoute == item.route) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Normal
                        }
                    )
                }
            )
        }
    }
}