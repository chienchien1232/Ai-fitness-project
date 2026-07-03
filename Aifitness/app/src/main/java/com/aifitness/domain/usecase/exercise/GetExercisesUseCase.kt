package com.aifitness.domain.usecase.exercise

import com.aifitness.domain.model.Exercise
import com.aifitness.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExercisesUseCase @Inject constructor(
    private val repository: ExerciseRepository
) {

    operator fun invoke(): Flow<List<Exercise>> {
        return repository.getAllExercises()
    }
}