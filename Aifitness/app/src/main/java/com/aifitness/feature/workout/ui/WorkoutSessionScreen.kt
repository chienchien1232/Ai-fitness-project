package com.aifitness.feature.workout.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aifitness.app.ui.components.GlassTopBar
import com.aifitness.feature.workout.viewmodel.WorkoutSessionViewModel

@Composable
fun WorkoutSessionScreen(
    viewModel: WorkoutSessionViewModel = hiltViewModel()
) {

    val workout by viewModel.workout.collectAsState()
    val session by viewModel.session.collectAsState()

    if (workout == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Loading...")
        }
        return
    }

    val currentWorkout = workout!!

    val currentExercise =
        currentWorkout.exercises.getOrNull(session.currentExerciseIndex) ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        GlassTopBar(
            title = currentWorkout.name
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = currentExercise.exerciseId,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Set ${session.currentSet}")

        Text(
            "Rep ${session.currentRep}"
        )

        Spacer(modifier = Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = {
                val totalReps = (currentExercise.reps ?: 1).toFloat()
                session.currentRep / totalReps
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            "Calories : ${session.caloriesBurned}"
        )

        Text(
            "Elapsed : ${session.elapsedSeconds}s"
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.nextRep()
            }
        ) {
            Text("Next Rep")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.nextExercise()
            }
        ) {
            Text("Next Exercise")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.finishWorkout()
            }
        ) {
            Text("Finish Workout")
        }

    }
}
