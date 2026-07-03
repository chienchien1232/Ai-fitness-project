package com.aifitness.domain.model

data class DailyStats(

    val date: Long,

    val workoutMinutes: Int,

    val caloriesBurned: Float,

    val completedWorkouts: Int,

    val totalReps: Int
)