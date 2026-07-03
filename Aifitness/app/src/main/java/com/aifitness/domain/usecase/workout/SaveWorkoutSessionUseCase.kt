package com.aifitness.domain.usecase

import com.aifitness.domain.model.WorkoutSession
import com.aifitness.domain.repository.WorkoutSessionRepository
import javax.inject.Inject

class SaveWorkoutSessionUseCase @Inject constructor(
    private val repository: WorkoutSessionRepository
) {

    suspend operator fun invoke(
        session: WorkoutSession
    ) {

        repository.insertSession(session)

    }

}