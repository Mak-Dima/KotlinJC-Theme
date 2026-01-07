package com.example.kotlinjc_theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuBar(
    innerPadding: PaddingValues,
    navController: NavController
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val labels = listOf("Data", "Settings")


    NavigationBar(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        labels.forEachIndexed{ index, label ->
            NavigationBarItem(
                icon = {},
                label = {
                    Text(label)
                },
                selected = index == selectedItem,
                onClick = {
                    selectedItem = index
                }
            )
        }
    }
}

@PreviewScreenSizes
@Composable
fun MenuBarPreview() {
    val navController = rememberNavController()
    MenuBar(PaddingValues(), navController)
}