package com.aifitness.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun ProgressRing(progress: Float) {

    Canvas(modifier = Modifier) {

        drawArc(
            color = Color.Gray.copy(alpha = 0.3f),
            startAngle = -90f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(20f, cap = StrokeCap.Round)
        )

        drawArc(
            color = Color.Green,
            startAngle = -90f,
            sweepAngle = 360f * progress,
            useCenter = false,
            style = Stroke(20f, cap = StrokeCap.Round)
        )
    }
}