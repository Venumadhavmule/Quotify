package com.venu.quotify.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.venu.quotify.ui.theme.QuotifyTheme

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
            contentDescription = "Top App Bar",
//            modifier = Modifier.size(20.dp),
            alignment = Alignment.Center,

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