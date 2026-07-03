package com.aifitness.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aifitness.app.ui.screen.*
import com.aifitness.feature.workout.navigation.workoutScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.route
    ) {
        composable(AppDestination.Home.route) {
            HomeScreen(
                onNavigateToAICoach = {
                    navController.navigate(AppDestination.AICoach.route)
                },
                onNavigateToWorkout = {
                    navController.navigate(AppDestination.Workout.route)
                },
                onNavigateToTrain = {
                    navController.navigate(AppDestination.Train.route)
                },
                onNavigateToStats = {
                    navController.navigate(AppDestination.Stats.route)
                },
                onNavigateToProfile = {
                    navController.navigate(AppDestination.Profile.route)
                }
            )
        }

        composable(AppDestination.AICoach.route) {
            ChatScreen()
        }

        // Feature Workout Navigation
        workoutScreen()

        composable(AppDestination.AIHealth.route) {
            HealthScreen()
        }

        composable(AppDestination.Train.route) {
            TrainScreen()
        }

        composable(AppDestination.Stats.route) {
            StatsScreen()
        }

        composable(AppDestination.Profile.route) {
            ProfileScreen()
        }
    }
}
