package com.aifitness.feature.workout.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aifitness.feature.workout.ui.WorkoutScreen

const val WORKOUT_ROUTE = "workout_route"

fun NavController.navigateToWorkout(navOptions: NavOptions? = null) {
    this.navigate(WORKOUT_ROUTE, navOptions)
}

fun NavGraphBuilder.workoutScreen() {
    composable(route = WORKOUT_ROUTE) {
        WorkoutScreen()
    }
}