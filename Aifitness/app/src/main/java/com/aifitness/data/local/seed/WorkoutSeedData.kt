package com.aifitness.data.local.seed

import com.aifitness.data.mapper.WorkoutMapper
import com.aifitness.domain.model.Difficulty
import com.aifitness.domain.model.Workout
import com.aifitness.domain.model.WorkoutExercise

object WorkoutSeedData {

    private val domainWorkouts = listOf(
        Workout(
            id = "full_body_beginner",
            name = "Full Body Beginner",
            description = "A simple full body workout for beginners",
            difficulty = Difficulty.BEGINNER,
            estimatedDurationMinutes = 15,
            exercises = listOf(
                WorkoutExercise("push_up", 3, 10, null, 60),
                WorkoutExercise("squat", 3, 12, null, 60),
                WorkoutExercise("plank", 3, null, 30, 60)
            )
        ),
        Workout(
            id = "upper_body_focus",
            name = "Upper Body Focus",
            description = "Focus on chest, back and arms",
            difficulty = Difficulty.INTERMEDIATE,
            estimatedDurationMinutes = 20,
            exercises = listOf(
                WorkoutExercise("push_up", 4, 15, null, 60),
                WorkoutExercise("plank", 4, null, 45, 60)
            )
        )
    )

    val workouts = domainWorkouts.map {
        WorkoutMapper.toEntity(it)
    }
}