package com.aifitness.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle // Thay cho Assessment/Settings
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.List // Thay cho History
import androidx.compose.ui.graphics.vector.ImageVector

import com.aifitness.feature.workout.navigation.WORKOUT_ROUTE

sealed class AppDestination(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Home : AppDestination("home", "Home", Icons.Default.Home)
    data object Workout : AppDestination(WORKOUT_ROUTE, "Workout", Icons.Default.PlayArrow)
    data object AICoach : AppDestination("ai_coach", "Coach", Icons.Default.CheckCircle)
    data object History : AppDestination("history", "History", Icons.Default.List)
    data object Profile : AppDestination("profile", "Profile", Icons.Default.AccountCircle)

    data object AIHealth : AppDestination("ai_health", "Health", Icons.Default.CheckCircle)
    data object Train : AppDestination("train", "Train", Icons.Default.PlayArrow)
    data object Stats : AppDestination("stats", "Stats", Icons.Default.CheckCircle)
    data object Settings : AppDestination("settings", "Settings", Icons.Default.CheckCircle)

    companion object {
        val bottomNavItems: List<AppDestination> by lazy {
            listOf(Home, Train, Stats, Profile)
        }
    }
}