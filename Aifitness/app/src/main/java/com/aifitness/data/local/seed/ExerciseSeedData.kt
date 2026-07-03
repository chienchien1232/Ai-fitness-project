package com.aifitness.data.local.seed

import com.aifitness.data.mapper.ExerciseMapper
import com.aifitness.domain.model.Exercise
import com.aifitness.domain.model.ExerciseCategory
import com.aifitness.domain.model.Difficulty

object ExerciseSeedData {

    private val domainExercises = listOf(
        Exercise(
            id = "push_up",
            name = "Push Up",
            description = "Classic upper body exercise",
            category = ExerciseCategory.CHEST,
            difficulty = Difficulty.BEGINNER,
            thumbnail = null,
            animation = null,
            caloriesPerMinute = 7.0f,
            estimatedDurationSeconds = 60,
            poseDetectionConfig = null
        ),
        Exercise(
            id = "squat",
            name = "Squat",
            description = "Lower body strength exercise",
            category = ExerciseCategory.LEGS,
            difficulty = Difficulty.BEGINNER,
            thumbnail = null,
            animation = null,
            caloriesPerMinute = 6.5f,
            estimatedDurationSeconds = 60,
            poseDetectionConfig = null
        ),
        Exercise(
            id = "plank",
            name = "Plank",
            description = "Core stability exercise",
            category = ExerciseCategory.CORE,
            difficulty = Difficulty.BEGINNER,
            thumbnail = null,
            animation = null,
            caloriesPerMinute = 5.0f,
            estimatedDurationSeconds = 60,
            poseDetectionConfig = null
        )
    )

    val exercises = domainExercises.map {
        ExerciseMapper.toEntity(it)
    }
}