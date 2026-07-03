package com.aifitness.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aifitness.app.ui.components.GlassTopBar
import com.aifitness.app.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToAICoach: () -> Unit = {},
    onNavigateToWorkout: () -> Unit = {},
    onNavigateToTrain: () -> Unit = {},
    onNavigateToStats: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    val globalScrollState = rememberScrollState()
    val metrics by viewModel.fitnessMetricsState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3F2FD), // Light Blue 50
                        Color(0xFFE3F2FD)  // Light Blue 100
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(globalScrollState)
                .padding(bottom = 110.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Khoảng trống dự phòng cho Top Bar cố định (Tăng lên để không bị che nội dung)
            Spacer(modifier = Modifier.height(88.dp))

            // AI Coach & Workout Today Cards + Water & Weight
            HomeMiddleSection(
                onAICoachClick = onNavigateToAICoach,
                onTodayWorkoutClick = onNavigateToWorkout
            )

            // Today's Overview (Grid of 4 metrics)
            TodaySummarySection(metrics = metrics)

            // AI Health Coach Chat Card
            AITrainerSection(onAICoachClick = onNavigateToAICoach)

            // Today's Workout Detail Card
            WorkoutTodaySection(onTodayWorkoutClick = onNavigateToWorkout)

            // Recent Activity
            RecentActivitySection()
        }

        // Fixed Top Bar lơ lửng (Đẩy sát lên mép trên cùng)
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 0.dp)
                .statusBarsPadding()
        ) {
            GlassTopBar(
                title = "AI FITNESS COACH",
                onActionClick = { /* TODO */ }
            )
        }
    }
}
