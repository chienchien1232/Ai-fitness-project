package com.aifitness.app.navigation
import com.aifitness.feature.workout.navigation.navigateToWorkoutSession
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aifitness.app.ui.screen.ChatScreen
import com.aifitness.app.ui.screen.HealthScreen
import com.aifitness.app.ui.screen.HomeScreen
import com.aifitness.app.ui.screen.ProfileScreen
import com.aifitness.app.ui.screen.StatsScreen
import com.aifitness.app.ui.screen.TrainScreen
import com.aifitness.feature.workout.navigation.navigateToWorkoutDetail
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

        // Workout Feature
        workoutScreen(
            onWorkoutClick = { workoutId ->
                navController.navigateToWorkoutDetail(workoutId)
            },
            onStartWorkout = { workoutId ->
                navController.navigateToWorkoutSession(workoutId)
            }
        )

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