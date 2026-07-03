package com.aifitness.data.repository

import com.aifitness.data.local.dao.WorkoutSessionDao
import com.aifitness.data.mapper.WorkoutSessionMapper
import com.aifitness.domain.model.WorkoutSession
import com.aifitness.domain.repository.WorkoutSessionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkoutSessionRepositoryImpl @Inject constructor(
    private val dao: WorkoutSessionDao
) : WorkoutSessionRepository {

    override suspend fun getAllSessions(): List<WorkoutSession> = withContext(Dispatchers.IO) {
        dao.getAllSessions().map(WorkoutSessionMapper::toDomain)
    }

    override suspend fun getSessionById(id: String): WorkoutSession? = withContext(Dispatchers.IO) {
        dao.getSessionById(id)?.let(WorkoutSessionMapper::toDomain)
    }

    override suspend fun getSessionsByWorkout(workoutId: String): List<WorkoutSession> = withContext(Dispatchers.IO) {
        dao.getSessionsByWorkout(workoutId).map(WorkoutSessionMapper::toDomain)
    }

    override suspend fun saveSession(session: WorkoutSession) = withContext(Dispatchers.IO) {
        dao.insertSession(WorkoutSessionMapper.toEntity(session))
    }

    override suspend fun updateSession(session: WorkoutSession) = withContext(Dispatchers.IO) {
        dao.updateSession(WorkoutSessionMapper.toEntity(session))
    }

    override suspend fun deleteSession(id: String) = withContext(Dispatchers.IO) {
        dao.deleteSessionById(id)
    }
}