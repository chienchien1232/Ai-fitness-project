package com.aifitness.data.repository

import com.aifitness.data.local.dao.ExerciseDao
import com.aifitness.data.mapper.ExerciseMapper
import com.aifitness.domain.model.Exercise
import com.aifitness.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val dao: ExerciseDao
) : ExerciseRepository {

    override fun getAllExercises(): Flow<List<Exercise>> {
        return dao.getAllExercises().map { entities ->
            entities.map(ExerciseMapper::toDomain)
        }
    }

    override suspend fun getExerciseById(id: String): Exercise? {
        return dao.getExerciseById(id)?.let(ExerciseMapper::toDomain)
    }

    override suspend fun getExercisesByCategory(category: String): List<Exercise> {
        return dao.getExercisesByCategory(category).map(ExerciseMapper::toDomain)
    }

    override suspend fun searchExercises(keyword: String): List<Exercise> {
        return dao.searchExercises(keyword).map(ExerciseMapper::toDomain)
    }

    override suspend fun insertExercise(exercise: Exercise) {
        dao.insertExercise(ExerciseMapper.toEntity(exercise))
    }

    override suspend fun insertExercises(exercises: List<Exercise>) {
        dao.insertExercises(exercises.map(ExerciseMapper::toEntity))
    }

    override suspend fun updateExercise(exercise: Exercise) {
        dao.updateExercise(ExerciseMapper.toEntity(exercise))
    }

    override suspend fun deleteExercise(id: String) {
        dao.deleteExerciseById(id)
    }
}