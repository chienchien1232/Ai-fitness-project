package com.aifitness.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_sessions")
data class WorkoutSessionEntity(

    @PrimaryKey
    val id: String,

    val workoutId: String,

    val startTime: Long,

    val endTime: Long?,

    val status: String,

    /**
     * JSON List<ExerciseResult>
     */
    val results: String,

    val totalCalories: Float
)