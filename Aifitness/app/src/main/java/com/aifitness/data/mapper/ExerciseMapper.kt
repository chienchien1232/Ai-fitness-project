package com.aifitness.data.mapper

import com.aifitness.data.local.entity.ExerciseEntity
import com.aifitness.domain.model.Difficulty
import com.aifitness.domain.model.Exercise
import com.aifitness.domain.model.ExerciseCategory
import com.aifitness.domain.model.PoseDetectionConfig
import com.google.gson.Gson

object ExerciseMapper {

    private val gson = Gson()

    fun toDomain(entity: ExerciseEntity): Exercise {
        return Exercise(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            category = ExerciseCategory.valueOf(entity.category),
            difficulty = Difficulty.valueOf(entity.difficulty),
            thumbnail = entity.thumbnail,
            animation = entity.animation,
            caloriesPerMinute = entity.caloriesPerMinute,
            estimatedDurationSeconds = entity.estimatedDurationSeconds,
            poseDetectionConfig = entity.poseDetectionConfig?.let {
                gson.fromJson(
                    it,
                    PoseDetectionConfig::class.java
                )
            }
        )
    }

    fun toEntity(domain: Exercise): ExerciseEntity {
        return ExerciseEntity(
            id = domain.id,
            name = domain.name,
            description = domain.description,
            category = domain.category.name,
            difficulty = domain.difficulty.name,
            thumbnail = domain.thumbnail,
            animation = domain.animation,
            caloriesPerMinute = domain.caloriesPerMinute,
            estimatedDurationSeconds = domain.estimatedDurationSeconds,
            poseDetectionConfig = domain.poseDetectionConfig?.let {
                gson.toJson(it)
            }
        )
    }
}