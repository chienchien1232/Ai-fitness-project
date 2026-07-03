package com.aifitness.feature.workout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aifitness.app.ui.components.GlassTopBar
import com.aifitness.feature.workout.component.WorkoutCard
import com.aifitness.feature.workout.viewmodel.WorkoutViewModel

@Composable
fun WorkoutScreen(
    onWorkoutClick: (String) -> Unit,
    viewModel: WorkoutViewModel = hiltViewModel()
) {
    val workouts by viewModel.workouts.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3F2FD), // Light Blue 50
                        Color(0xFFBBDEFB)  // Light Blue 100
                    )
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Danh sách Workout
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 96.dp, bottom = 110.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(workouts) { workout ->
                    WorkoutCard(
                        workout = workout,
                        onClick = {
                            onWorkoutClick(workout.id)
                        }
                    )
                }
            }
        }

        // Fixed Top Bar lơ lửng (Đẩy sát lên mép trên cùng)
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 0.dp)
                .statusBarsPadding()
        ) {
            GlassTopBar(title = "Workouts")
        }
    }
}
