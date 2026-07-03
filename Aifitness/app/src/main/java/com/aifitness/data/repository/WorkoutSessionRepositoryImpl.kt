package com.aifitness.data.repository

import com.aifitness.data.local.dao.WorkoutSessionDao
import com.aifitness.data.mapper.WorkoutSessionMapper
import com.aifitness.domain.model.WorkoutSession
import com.aifitness.domain.repository.WorkoutSessionRepository
import javax.inject.Inject

class WorkoutSessionRepositoryImpl @Inject constructor(
    private val dao: WorkoutSessionDao
) : WorkoutSessionRepository {

    override suspend fun getAllSessions(): List<WorkoutSession> {
        return dao.getAllSessions().map(WorkoutSessionMapper::toDomain)
    }

    override suspend fun getSessionById(id: String): WorkoutSession? {
        return dao.getSessionById(id)?.let(WorkoutSessionMapper::toDomain)
    }

    override suspend fun getSessionsByWorkout(workoutId: String): List<WorkoutSession> {
        return dao.getSessionsByWorkout(workoutId).map(WorkoutSessionMapper::toDomain)
    }

    override suspend fun saveSession(session: WorkoutSession) {
        dao.insertSession(WorkoutSessionMapper.toEntity(session))
    }

    override suspend fun updateSession(session: WorkoutSession) {
        dao.updateSession(WorkoutSessionMapper.toEntity(session))
    }

    override suspend fun deleteSession(id: String) {
        dao.deleteSessionById(id)
    }
}