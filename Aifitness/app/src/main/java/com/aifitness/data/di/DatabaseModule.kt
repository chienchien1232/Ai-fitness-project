package com.aifitness.data.di

import android.content.Context
import androidx.room.Room
import com.aifitness.data.local.AiFitnessDatabase
import com.aifitness.data.local.DatabaseCallback
import com.aifitness.data.local.dao.ExerciseDao
import com.aifitness.data.local.dao.WorkoutDao
import com.aifitness.data.local.dao.WorkoutSessionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
        exerciseDaoProvider: Provider<ExerciseDao>,
        workoutDaoProvider: Provider<WorkoutDao>
    ): AiFitnessDatabase {
        return Room.databaseBuilder(
            context,
            AiFitnessDatabase::class.java,
            "ai_fitness_db"
        )
        .addCallback(DatabaseCallback(exerciseDaoProvider, workoutDaoProvider))
        .build()
    }

    @Provides
    fun provideExerciseDao(database: AiFitnessDatabase): ExerciseDao {
        return database.exerciseDao()
    }

    @Provides
    fun provideWorkoutDao(database: AiFitnessDatabase): WorkoutDao {
        return database.workoutDao()
    }

    @Provides
    fun provideWorkoutSessionDao(database: AiFitnessDatabase): WorkoutSessionDao {
        return database.workoutSessionDao()
    }
}