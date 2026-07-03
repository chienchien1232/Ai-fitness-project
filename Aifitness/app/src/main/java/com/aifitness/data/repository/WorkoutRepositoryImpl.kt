package com.aifitness.data.repository

import com.aifitness.data.local.dao.WorkoutDao
import com.aifitness.data.mapper.WorkoutMapper
import com.aifitness.domain.model.Workout
import com.aifitness.domain.repository.WorkoutRepository
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val dao: WorkoutDao
) : WorkoutRepository {

    override suspend fun getAllWorkouts(): List<Workout> {
        return dao.getAllWorkouts().map(WorkoutMapper::toDomain)
    }

    override suspend fun getWorkoutById(id: String): Workout? {
        return dao.getWorkoutById(id)?.let(WorkoutMapper::toDomain)
    }

    override suspend fun insertWorkout(workout: Workout) {
        dao.insertWorkout(WorkoutMapper.toEntity(workout))
    }

    override suspend fun updateWorkout(workout: Workout) {
        dao.updateWorkout(WorkoutMapper.toEntity(workout))
    }

    override suspend fun deleteWorkout(id: String) {
        dao.deleteWorkoutById(id)
    }
}