package com.aifitness.domain.repository

import com.aifitness.domain.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getAllExercises(): Flow<List<Exercise>>

    suspend fun getExerciseById(id: String): Exercise?

    suspend fun getExercisesByCategory(category: String): List<Exercise>

    suspend fun searchExercises(keyword: String): List<Exercise>

    suspend fun insertExercise(exercise: Exercise)

    suspend fun insertExercises(exercises: List<Exercise>)

    suspend fun updateExercise(exercise: Exercise)

    suspend fun deleteExercise(id: String)
}