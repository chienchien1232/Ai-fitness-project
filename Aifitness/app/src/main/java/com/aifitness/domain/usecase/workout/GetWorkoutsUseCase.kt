package com.aifitness.domain.usecase.workout

import com.aifitness.domain.model.Workout
import com.aifitness.domain.repository.WorkoutRepository
import javax.inject.Inject

class GetWorkoutsUseCase @Inject constructor(
    private val repository: WorkoutRepository
) {

    suspend operator fun invoke(): List<Workout> {
        return repository.getAllWorkouts()
    }
}