package com.aifitness.data.local

import androidx.room.TypeConverter
import com.aifitness.domain.model.ExerciseResult
import com.aifitness.domain.model.PoseDetectionConfig
import com.aifitness.domain.model.WorkoutExercise
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    // ===== List<WorkoutExercise> =====
    @TypeConverter
    fun fromWorkoutExerciseList(value: List<WorkoutExercise>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toWorkoutExerciseList(value: String): List<WorkoutExercise> {
        val type = object : TypeToken<List<WorkoutExercise>>() {}.type
        return gson.fromJson(value, type)
    }

    // ===== List<ExerciseResult> =====
    @TypeConverter
    fun fromExerciseResultList(value: List<ExerciseResult>?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toExerciseResultList(value: String): List<ExerciseResult> {
        val type = object : TypeToken<List<ExerciseResult>>() {}.type
        return gson.fromJson(value, type)
    }

    // ===== PoseDetectionConfig =====
    @TypeConverter
    fun fromPoseDetectionConfig(value: PoseDetectionConfig?): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPoseDetectionConfig(value: String): PoseDetectionConfig {
        return gson.fromJson(value, PoseDetectionConfig::class.java)
    }
}