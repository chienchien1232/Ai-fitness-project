package com.aifitness.domain.repository

import com.aifitness.domain.model.WorkoutSession

interface WorkoutSessionRepository {

    suspend fun getAllSessions(): List<WorkoutSession>

    suspend fun getSessionById(id: String): WorkoutSession?

    suspend fun getSessionsByWorkout(workoutId: String): List<WorkoutSession>

    suspend fun saveSession(session: WorkoutSession)

    suspend fun updateSession(session: WorkoutSession)

    suspend fun deleteSession(id: String)
}