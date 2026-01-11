package com.example.kotlinjc_theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinjc_theme.ui.theme.KotlinJCThemeTheme
import com.example.kotlinjc_theme.views.Data
import com.example.kotlinjc_theme.views.MenuBar
import com.example.kotlinjc_theme.views.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            var isDarkTheme by remember { mutableStateOf(false) }

            KotlinJCThemeTheme(darkTheme = isDarkTheme) {
                Scaffold(
                    bottomBar = {
                        MenuBar(navController)
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Data
                    ) {
                        composable<Data>{ Data() }
                        composable<Settings>{ Settings(isDarkTheme, {isDarkTheme = !isDarkTheme}) }
                    }
                }
            }
        }
    }
}
