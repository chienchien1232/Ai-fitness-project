package com.aifitness.domain.repository

import com.aifitness.domain.model.Workout

interface WorkoutRepository {

    suspend fun getAllWorkouts(): List<Workout>

    suspend fun getWorkoutById(id: String): Workout?

    suspend fun insertWorkout(workout: Workout)

    suspend fun updateWorkout(workout: Workout)

    suspend fun deleteWorkout(id: String)
}