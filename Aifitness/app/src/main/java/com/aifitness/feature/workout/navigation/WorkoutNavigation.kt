package com.aifitness.feature.workout.navigation
import com.aifitness.feature.workout.ui.WorkoutSessionScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aifitness.feature.workout.ui.WorkoutDetailScreen
import com.aifitness.feature.workout.ui.WorkoutScreen

const val WORKOUT_SESSION_ROUTE =
    "workout_session/{workoutId}"
const val WORKOUT_ROUTE = "workout_route"
const val WORKOUT_DETAIL_ROUTE = "workout_detail/{workoutId}"

fun NavController.navigateToWorkout(navOptions: NavOptions? = null) {
    navigate(WORKOUT_ROUTE, navOptions)
}
fun NavController.navigateToWorkoutSession(
    workoutId: String
) {
    navigate("workout_session/$workoutId")
}
fun NavController.navigateToWorkoutDetail(workoutId: String) {
    navigate("workout_detail/$workoutId")
}

fun NavGraphBuilder.workoutScreen(
    onWorkoutClick: (String) -> Unit,
    onStartWorkout: (String) -> Unit
) {

    composable(route = WORKOUT_ROUTE) {
        WorkoutScreen(
            onWorkoutClick = onWorkoutClick
        )
    }

    composable(
        route = WORKOUT_SESSION_ROUTE,
        arguments = listOf(
            navArgument("workoutId") {
                type = NavType.StringType
            }
        )
    ) {
        WorkoutSessionScreen()
    }
    composable(
        route = WORKOUT_DETAIL_ROUTE,
        arguments = listOf(
            navArgument("workoutId") {
                type = NavType.StringType
            }
        )
    ) {
        WorkoutDetailScreen(
            onStartWorkout = onStartWorkout
        )
    }
}