package com.aifitness.feature.workout.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AvTimer
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aifitness.app.ui.components.GlassCard
import com.aifitness.domain.model.Workout

@Composable
fun WorkoutCard(
    workout: Workout,
    onClick: () -> Unit
) {
    GlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        padding = PaddingValues(0.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = workout.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF1A1A1A),
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = workout.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black.copy(alpha = 0.6f),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                WorkoutInfoItem(
                    icon = Icons.Default.Speed,
                    label = workout.difficulty.name.lowercase().capitalize()
                )
                WorkoutInfoItem(
                    icon = Icons.Default.AvTimer,
                    label = "${workout.estimatedDurationMinutes} min"
                )
                WorkoutInfoItem(
                    icon = Icons.Default.FitnessCenter,
                    label = "${workout.exercises.size} Exercises"
                )
            }
        }
    }
}

@Composable
private fun WorkoutInfoItem(
    icon: ImageVector,
    label: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            tint = Color(0xFF6200EE)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black.copy(alpha = 0.7f),
            fontWeight = FontWeight.Bold
        )
    }
}
