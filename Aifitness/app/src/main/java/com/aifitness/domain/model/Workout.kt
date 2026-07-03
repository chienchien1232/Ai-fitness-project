package com.aifitness.domain.model

data class Workout(

    val id: String,

    val name: String,

    val description: String,

    val difficulty: Difficulty,

    val estimatedDurationMinutes: Int,

    val exercises: List<WorkoutExercise>
)