package com.aifitness.domain.model

data class ExerciseResult(

    val exerciseId: String,

    val completedSets: Int,

    val completedReps: Int,

    val durationSeconds: Int,

    val caloriesBurned: Float
)