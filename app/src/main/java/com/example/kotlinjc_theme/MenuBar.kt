package com.example.kotlinjc_theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MenuBar( navController: NavController) {
    var selectedItem by remember { mutableStateOf<AppRoute>(Data) }

    NavigationBar(
        modifier = Modifier
            .padding()
    ) {
        NavigationBarItem(
            icon = {},
            label = {
                Text("Data")
            },
            selected = Data == selectedItem,
            onClick = {
                selectedItem = Data
                navController.navigate(Data)
            }
        )

        NavigationBarItem(
            icon = {},
            label = {
                Text("Settings")
            },
            selected = Settings == selectedItem,
            onClick = {
                selectedItem = Settings
                navController.navigate(Settings)
            }
        )
    }
}

@PreviewScreenSizes
@Composable
fun MenuBarPreview() {
    val navController = rememberNavController()
    MenuBar(navController)
}