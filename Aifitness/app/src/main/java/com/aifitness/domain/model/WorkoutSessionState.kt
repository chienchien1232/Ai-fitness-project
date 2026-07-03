package com.aifitness.domain.model

data class WorkoutSessionState(
    val currentExerciseIndex: Int = 0,
    val currentSet: Int = 1,
    val currentRep: Int = 0,
    val elapsedSeconds: Int = 0,
    val caloriesBurned: Float = 0f,
    val isPaused: Boolean = false,
    val isCompleted: Boolean = false
)