package com.aifitness.app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aifitness.app.ui.components.AnimatedBackground
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

    Box(modifier = Modifier.fillMaxSize()) {
        // Nền động Liquid
        AnimatedBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(globalScrollState)
                .padding(bottom = 110.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Top Bar
            Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                GlassTopBar(
                    title = "AI FITNESS COACH",
                    onActionClick = { /* TODO */ }
                )
            }

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
    }
}
