package com.example.kotlinjc_theme

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinjc_theme.ui.theme.KotlinJCThemeTheme
import com.example.kotlinjc_theme.views.Data
import com.example.kotlinjc_theme.views.MenuBar
import com.example.kotlinjc_theme.views.Settings
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

fun updateTheme(context: Context, isDarkTheme: Boolean) {
    runBlocking {
        context.dataStore.updateData { preferences ->
            preferences.toMutablePreferences()
                .apply { this[IS_DARK_THEME] = isDarkTheme }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainContent( this)
        }
    }
}


@Composable
fun MainContent(context: Context) {
    val navController = rememberNavController()
    val isDarkThemeStored = context.dataStore.data.map { preferences ->
        preferences[IS_DARK_THEME] ?: false
    }
    var isDarkTheme = isDarkThemeStored.collectAsState(initial = false).value

    KotlinJCThemeTheme(darkTheme = isDarkTheme) {
        Scaffold(
            bottomBar = {
                MenuBar(navController)
            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = navController,
                    startDestination = Data
                ) {
                    composable<Data> { Data() }
                    composable<Settings> {
                        Settings(
                            isDarkTheme
                        ) {
                            isDarkTheme = !isDarkTheme
                            updateTheme(context, !isDarkTheme)
                        }
                    }
                }
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun MainActivityPreview() {
    MainContent(LocalContext.current)
}
