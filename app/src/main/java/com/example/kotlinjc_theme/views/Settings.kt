package com.example.kotlinjc_theme.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Settings(
    isDarkTheme: Boolean,
    onThemeUpdate: () -> Unit
) {
    val themes = listOf("Light", "Dark")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top)
    ) {
        Text(
            text = "Settings",
            fontSize = 26.sp
        )

        themes.forEachIndexed { index, theme ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically

            ) {
                RadioButton(
                    selected = (isDarkTheme && index == 1) || (!isDarkTheme && index == 0),
                    onClick = { onThemeUpdate() }
                )
                Text(
                    text = theme,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun SettingsPreview() {
    Settings(false,{})
}