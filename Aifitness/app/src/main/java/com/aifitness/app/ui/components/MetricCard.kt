package com.aifitness.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MetricCard(
    title: String,
    value: String,
    unit: String = "",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color.Black.copy(alpha = 0.04f),
                spotColor = Color.Black.copy(alpha = 0.08f)
            )
            .background(
                color = Color.White.copy(alpha = 0.8f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = title.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            letterSpacing = 1.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Black,
                color = Color.Black
            )
            if (unit.isNotEmpty()) {
                Text(
                    text = " $unit",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 3.dp)
                )
            }
        }
    }
}
