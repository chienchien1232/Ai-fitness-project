package com.aifitness.feature.workout.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aifitness.app.ui.components.AnimatedBackground
import com.aifitness.app.ui.components.GlassTopBar
import com.aifitness.feature.workout.component.WorkoutCard
import com.aifitness.feature.workout.viewmodel.WorkoutViewModel

@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel = hiltViewModel()
) {
    val workouts by viewModel.workouts.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Nền động Liquid
        AnimatedBackground()

        Column(modifier = Modifier.fillMaxSize()) {
            // 2. Top Bar với hiệu ứng Glass
            Box(modifier = Modifier.padding(16.dp)) {
                GlassTopBar(title = "Workouts")
            }

            // 3. Danh sách Workout
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(workouts) { workout ->
                    WorkoutCard(
                        workout = workout,
                        onClick = {
                            // TODO: Navigate to Workout Detail
                        }
                    )
                }
                
                // Khoảng trống ở cuối để không bị Bottom Bar che
                item {
                    Spacer(modifier = Modifier.height(110.dp))
                }
            }
        }
    }
}
