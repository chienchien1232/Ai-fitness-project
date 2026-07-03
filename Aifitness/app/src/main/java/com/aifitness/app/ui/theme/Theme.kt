package com.aifitness.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
// Remove the automatic kotlin.text.Typography import if it's hidden up there!

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    background = Background,
    surface = Surface,
    onPrimary = OnPrimary,
    onBackground = OnBackground,
    onSurface = OnSurface
)

@Composable
fun AiFitnessTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        // This will now correctly reference the 'Typography' variable defined in your Type.kt file
        typography = Typography,
        // This will reference the 'Shapes' variable in your Shape.kt file
        shapes = Shapes,
        content = content
    )
}