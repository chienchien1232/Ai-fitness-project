package com.aifitness.data.mapper

import com.aifitness.data.local.entity.WorkoutSessionEntity
import com.aifitness.domain.model.ExerciseResult
import com.aifitness.domain.model.WorkoutSession
import com.aifitness.domain.model.WorkoutStatus
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object WorkoutSessionMapper {

    private val gson = Gson()

    fun toDomain(entity: WorkoutSessionEntity): WorkoutSession {

        val type = object : TypeToken<List<ExerciseResult>>() {}.type

        return WorkoutSession(
            id = entity.id,
            workoutId = entity.workoutId,
            startTime = entity.startTime,
            endTime = entity.endTime,
            status = WorkoutStatus.valueOf(entity.status),
            results = gson.fromJson(entity.results, type),
            totalCalories = entity.totalCalories
        )
    }

    fun toEntity(domain: WorkoutSession): WorkoutSessionEntity {

        return WorkoutSessionEntity(
            id = domain.id,
            workoutId = domain.workoutId,
            startTime = domain.startTime,
            endTime = domain.endTime,
            status = domain.status.name,
            results = gson.toJson(domain.results),
            totalCalories = domain.totalCalories
        )
    }
}