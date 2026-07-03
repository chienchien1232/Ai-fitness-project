package com.aifitness.feature.workout.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aifitness.feature.workout.viewmodel.WorkoutDetailViewModel

@Composable
fun WorkoutDetailScreen(
    onStartWorkout: (String) -> Unit = {},
    viewModel: WorkoutDetailViewModel = hiltViewModel()
) {

    val workout by viewModel.workout.collectAsState()

    if (workout == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    val currentWorkout = workout!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = currentWorkout.name,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = currentWorkout.description,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Exercises",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(currentWorkout.exercises) { exercise ->

                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {

                    Text(
                        text = exercise.exerciseId,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "${exercise.sets} sets",
                        style = MaterialTheme.typography.bodyMedium
                    )

                }

            }

        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onStartWorkout(currentWorkout.id)
            }
        ) {

            Text("Start Workout")

        }

    }
}
