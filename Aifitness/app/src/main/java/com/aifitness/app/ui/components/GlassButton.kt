package com.aifitness.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GlassButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(16.dp),
                ambientColor = Color.Black.copy(alpha = 0.05f),
                spotColor = Color.Black.copy(alpha = 0.08f)
            )
            .background(
                color = Color.White.copy(alpha = 0.70f),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = Color.Black
        )
    }
}