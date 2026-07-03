package com.aifitness.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GlassTopBar(
    title: String,
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(28.dp),
                clip = false,
                ambientColor = Color.Black.copy(alpha = 0.1f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            ),
        shape = RoundedCornerShape(28.dp),
        color = Color.White.copy(alpha = 0.65f),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.3f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title.uppercase(),
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF111111)
            )

            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Action",
                    tint = Color(0xFF4CAF50) // Đồng bộ màu với Bottom Bar
                )
            }
        }
    }
}
