package com.aifitness.domain.model

data class Exercise(

    val id: String,

    val name: String,

    val description: String,

    val category: ExerciseCategory,

    val difficulty: Difficulty,

    val thumbnail: String?,

    val animation: String?,

    val caloriesPerMinute: Float,

    val estimatedDurationSeconds: Int,

    val poseDetectionConfig: PoseDetectionConfig?
)