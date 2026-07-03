package com.aifitness.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(

    @PrimaryKey
    val id: String,

    val name: String,

    val description: String,

    val category: String,

    val difficulty: String,

    val thumbnail: String?,

    val animation: String?,

    val caloriesPerMinute: Float,

    val estimatedDurationSeconds: Int,

    /**
     * JSON của PoseDetectionConfig
     * Chuyển đổi bằng Room TypeConverter
     */
    val poseDetectionConfig: String?
)