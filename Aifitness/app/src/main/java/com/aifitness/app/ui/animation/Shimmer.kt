package com.aifitness.app.ui.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerItem(
    modifier: Modifier = Modifier,
    width: Float = 1000f,
    height: Float = 1000f,
    durationMillis: Int = 1200
) {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = width + height,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_animation"
    )

    val colors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(translateAnim - height, translateAnim - height),
        end = Offset(translateAnim, translateAnim)
    )

    Box(
        modifier = modifier
            .background(brush)
    )
}

@Composable
fun ShimmerPlaceholder() {
    Column(modifier = Modifier.padding(16.dp)) {
        repeat(5) {
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .padding(8.dp)
                        .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
                ) {
                    ShimmerItem(modifier = Modifier.fillMaxSize())
                }
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(20.dp)
                            .padding(8.dp)
                            .background(Color.LightGray, shape = MaterialTheme.shapes.small)
                    ) {
                        ShimmerItem(modifier = Modifier.fillMaxSize())
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(16.dp)
                            .padding(8.dp)
                            .background(Color.LightGray, shape = MaterialTheme.shapes.small)
                    ) {
                        ShimmerItem(modifier = Modifier.fillMaxSize())
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
