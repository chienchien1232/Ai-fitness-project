package com.aifitness.data.mapper

import com.aifitness.data.local.entity.WorkoutEntity
import com.aifitness.domain.model.Difficulty
import com.aifitness.domain.model.Workout
import com.aifitness.domain.model.WorkoutExercise
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object WorkoutMapper {

    private val gson = Gson()

    fun toDomain(entity: WorkoutEntity): Workout {

        val type = object : TypeToken<List<WorkoutExercise>>() {}.type

        return Workout(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            difficulty = Difficulty.valueOf(entity.difficulty),
            estimatedDurationMinutes = entity.estimatedDurationMinutes,
            exercises = gson.fromJson(entity.exercises, type)
        )
    }

    fun toEntity(domain: Workout): WorkoutEntity {

        return WorkoutEntity(
            id = domain.id,
            name = domain.name,
            description = domain.description,
            difficulty = domain.difficulty.name,
            estimatedDurationMinutes = domain.estimatedDurationMinutes,
            exercises = gson.toJson(domain.exercises)
        )
    }
}