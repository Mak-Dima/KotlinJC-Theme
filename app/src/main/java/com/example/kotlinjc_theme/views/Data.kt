package com.example.kotlinjc_theme.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Data() {
    val data = """
Lorem Ipsum is simply dummy text of the printing and typesetting industry.
Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
when an unknown printer took a galley of type and scrambled it to make a type specimen book.
It has survived not only five centuries, but also the leap into electronic typesetting,
remaining essentially unchanged.
It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
    """.trimIndent()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            border = BorderStroke(1.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            onClick = { print("UP") }
        )
        {
            Text(
                "Up",
                fontSize = 20.sp
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.White,
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.dp, Color.Blue),
        ) {
            Text(
                modifier = Modifier
                    .padding(20.dp),
                fontSize = 20.sp,
                text = data,
                textAlign = TextAlign.Start
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            border = BorderStroke(1.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Blue
            ),
            onClick = { print("DOWN") }
        )
        {
            Text(
                "Down",
                fontSize = 20.sp
            )
        }
    }
}

@PreviewScreenSizes
@Composable
fun DataPreview() {
    Data()
}