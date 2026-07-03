package com.aifitness.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(20.dp),
    content: @Composable () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 14.dp,
                shape = MaterialTheme.shapes.large,
                ambientColor = Color.Black.copy(alpha = 0.06f),
                spotColor = Color.Black.copy(alpha = 0.08f)
            ),

        shape = MaterialTheme.shapes.large,

        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.70f)
        ),

        border = BorderStroke(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.85f)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Box(
            modifier = Modifier.padding(padding)
        ) {
            content()
        }
    }
}