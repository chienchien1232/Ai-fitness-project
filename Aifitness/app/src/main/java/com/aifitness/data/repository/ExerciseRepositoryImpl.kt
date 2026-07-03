package com.aifitness.data.repository

import com.aifitness.data.local.dao.ExerciseDao
import com.aifitness.data.mapper.ExerciseMapper
import com.aifitness.domain.model.Exercise
import com.aifitness.domain.repository.ExerciseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val dao: ExerciseDao
) : ExerciseRepository {

    override fun getAllExercises(): Flow<List<Exercise>> {
        return dao.getAllExercises().map { entities ->
            entities.map(ExerciseMapper::toDomain)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getExerciseById(id: String): Exercise? = withContext(Dispatchers.IO) {
        dao.getExerciseById(id)?.let(ExerciseMapper::toDomain)
    }

    override suspend fun getExercisesByCategory(category: String): List<Exercise> = withContext(Dispatchers.IO) {
        dao.getExercisesByCategory(category).map(ExerciseMapper::toDomain)
    }

    override suspend fun searchExercises(keyword: String): List<Exercise> = withContext(Dispatchers.IO) {
        dao.searchExercises(keyword).map(ExerciseMapper::toDomain)
    }

    override suspend fun insertExercise(exercise: Exercise) = withContext(Dispatchers.IO) {
        dao.insertExercise(ExerciseMapper.toEntity(exercise))
    }

    override suspend fun insertExercises(exercises: List<Exercise>) = withContext(Dispatchers.IO) {
        dao.insertExercises(exercises.map(ExerciseMapper::toEntity))
    }

    override suspend fun updateExercise(exercise: Exercise) = withContext(Dispatchers.IO) {
        dao.updateExercise(ExerciseMapper.toEntity(exercise))
    }

    override suspend fun deleteExercise(id: String) = withContext(Dispatchers.IO) {
        dao.deleteExerciseById(id)
    }
}