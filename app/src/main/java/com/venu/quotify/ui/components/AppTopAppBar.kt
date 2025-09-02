package com.venu.quotify.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.venu.quotify.R
import com.venu.quotify.ui.theme.QuotifyTheme

@Composable
fun AppTopAppBar(
    navController: NavController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {

        when (currentDestination?.route) {
            "home" -> {
                Image(
                    painter = painterResource(
                        if (isSystemInDarkTheme()) {
                            R.drawable.quotify_header_dark
                        } else {
                            R.drawable.quotify_header_light
                        }
                    ),
                    contentDescription = "Top App Bar",
//            modifier = Modifier.size(20.dp),
                    alignment = Alignment.Center,

                    )
            }

            "favourite" -> {
                TopBarText("Favourite")
            }

            "create" -> {
                TopBarText("Create")
            }

            "profile" -> {
                TopBarText("Profile")

            }
            else -> {
                TopBarText("Home")
            }
        }
    }
}

@Composable
private fun TopBarText(route: String) {
    Text(
        text = route,
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
//        fontStyle = FontStyle.Italic
    )
}

@Preview
@Composable
fun TopBarPreview() {
    QuotifyTheme {
//        AppTopAppBar(icon = R.drawable.ic_launcher_background, navController = NavController(context = )) // Preview requires a NavController instance
    }
}