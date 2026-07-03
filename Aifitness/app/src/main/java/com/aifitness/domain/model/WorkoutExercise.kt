package com.aifitness.domain.model

data class WorkoutExercise(

    val exerciseId: String,

    val sets: Int,

    val reps: Int?,

    val durationSeconds: Int?,

    val restSeconds: Int
)