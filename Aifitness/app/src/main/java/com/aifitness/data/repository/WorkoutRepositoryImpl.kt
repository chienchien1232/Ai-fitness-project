package com.aifitness.data.repository

import com.aifitness.data.local.dao.WorkoutDao
import com.aifitness.data.mapper.WorkoutMapper
import com.aifitness.domain.model.Workout
import com.aifitness.domain.repository.WorkoutRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val dao: WorkoutDao
) : WorkoutRepository {

    override suspend fun getAllWorkouts(): List<Workout> = withContext(Dispatchers.IO) {
        dao.getAllWorkouts().map(WorkoutMapper::toDomain)
    }

    override suspend fun getWorkoutById(id: String): Workout? = withContext(Dispatchers.IO) {
        dao.getWorkoutById(id)?.let(WorkoutMapper::toDomain)
    }

    override suspend fun insertWorkout(workout: Workout) = withContext(Dispatchers.IO) {
        dao.insertWorkout(WorkoutMapper.toEntity(workout))
    }

    override suspend fun updateWorkout(workout: Workout) = withContext(Dispatchers.IO) {
        dao.updateWorkout(WorkoutMapper.toEntity(workout))
    }

    override suspend fun deleteWorkout(id: String) = withContext(Dispatchers.IO) {
        dao.deleteWorkoutById(id)
    }
}