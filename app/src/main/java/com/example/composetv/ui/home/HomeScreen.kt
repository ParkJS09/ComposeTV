package com.example.composetv.ui.home

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(title)
                },
                actions = {
                    ActionButton(
                        { Log.d("test", "test1") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                    ActionButton(
                        { Log.d("test", "test2") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                    ActionButton(
                        { Log.d("test", "test3") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                    ActionButton(
                        { Log.d("test", "test4") },
                        Icons.Filled.Favorite,
                        "Localized description"
                    )
                }
            )
        },
        bottomBar = { BottomNavigation() }
    ) {

    }
}

@Composable
fun ActionButton(callback: () -> Unit, icon: ImageVector, desc: String) {
    IconButton(onClick = callback) {
        Icon(icon, desc)
    }
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(modifier) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "???"
                )
            },
            label = {
                Text("???")
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.VideogameAsset,
                    contentDescription = "e?????????"
                )
            },
            label = {
                Text("e?????????")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.FeaturedVideo,
                    contentDescription = "VOD"
                )
            },
            label = {
                Text("VOD")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "MY"
                )
            },
            label = {
                Text("VOD")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.PlusOne,
                    contentDescription = "?????????"
                )
            },
            label = {
                Text("?????????")
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen("ComposeTV") {

    }
}