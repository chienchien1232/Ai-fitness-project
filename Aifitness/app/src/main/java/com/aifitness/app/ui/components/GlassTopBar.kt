package com.aifitness.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GlassTopBar(
    title: String,
    modifier: Modifier = Modifier,
    onActionClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
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
                tint = Color(0xDC202823)
            )
        }
    }
}
