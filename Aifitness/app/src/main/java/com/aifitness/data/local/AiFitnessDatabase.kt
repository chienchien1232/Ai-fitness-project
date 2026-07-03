package com.aifitness.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aifitness.data.local.dao.ExerciseDao
import com.aifitness.data.local.dao.WorkoutDao
import com.aifitness.data.local.dao.WorkoutSessionDao
import com.aifitness.data.local.entity.ExerciseEntity
import com.aifitness.data.local.entity.WorkoutEntity
import com.aifitness.data.local.entity.WorkoutSessionEntity

@Database(
    entities = [
        ExerciseEntity::class,
        WorkoutEntity::class,
        WorkoutSessionEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AiFitnessDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun workoutSessionDao(): WorkoutSessionDao
}