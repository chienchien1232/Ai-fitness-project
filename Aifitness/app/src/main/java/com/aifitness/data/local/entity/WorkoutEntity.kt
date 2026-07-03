package com.aifitness.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workouts")
data class WorkoutEntity(

    @PrimaryKey
    val id: String,

    val name: String,

    val description: String,

    val difficulty: String,

    val estimatedDurationMinutes: Int,

    /**
     * JSON List<WorkoutExercise>
     */
    val exercises: String
)