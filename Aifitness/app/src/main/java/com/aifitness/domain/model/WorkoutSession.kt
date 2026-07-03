package com.aifitness.domain.model

data class WorkoutSession(
    val id: String,
    val workoutId: String,
    val startTime: Long,
    val endTime: Long?,
    val status: WorkoutStatus,
    val results: List<ExerciseResult>,
    val totalCalories: Float
)