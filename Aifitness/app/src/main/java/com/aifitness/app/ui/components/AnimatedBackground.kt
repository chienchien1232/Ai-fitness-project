package com.aifitness.app.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun AnimatedBackground() {

    val transition = rememberInfiniteTransition(label = "bg")

    val xOffset by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(14000, easing = LinearEasing)
        ),
        label = "x"
    )

    val yOffset by transition.animateFloat(
        initialValue = 0f,
        targetValue = 600f,
        animationSpec = infiniteRepeatable(
            animation = tween(18000, easing = LinearEasing)
        ),
        label = "y"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFF2F5FA),
                        Color(0xFFE6EBF5)
                    ),
                    center = Offset(xOffset, yOffset),
                    radius = 1400f
                )
            )
    )
}