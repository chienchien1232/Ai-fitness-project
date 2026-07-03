package com.aifitness.data.di

import com.aifitness.data.repository.ExerciseRepositoryImpl
import com.aifitness.data.repository.WorkoutRepositoryImpl
import com.aifitness.data.repository.WorkoutSessionRepositoryImpl
import com.aifitness.domain.repository.ExerciseRepository
import com.aifitness.domain.repository.WorkoutRepository
import com.aifitness.domain.repository.WorkoutSessionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindExerciseRepository(
        impl: ExerciseRepositoryImpl
    ): ExerciseRepository

    @Binds
    @Singleton
    abstract fun bindWorkoutRepository(
        impl: WorkoutRepositoryImpl
    ): WorkoutRepository

    @Binds
    @Singleton
    abstract fun bindWorkoutSessionRepository(
        impl: WorkoutSessionRepositoryImpl
    ): WorkoutSessionRepository
}