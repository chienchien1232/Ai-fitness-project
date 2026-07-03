package com.aifitness.data.local.dao

import androidx.room.*
import com.aifitness.data.local.entity.WorkoutEntity

@Dao
interface WorkoutDao {

    @Query("SELECT * FROM workouts")
    suspend fun getAllWorkouts(): List<WorkoutEntity>

    @Query("SELECT * FROM workouts WHERE id = :id")
    suspend fun getWorkoutById(id: String): WorkoutEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkout(workout: WorkoutEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkouts(workouts: List<WorkoutEntity>)

    @Update
    suspend fun updateWorkout(workout: WorkoutEntity)

    @Delete
    suspend fun deleteWorkout(workout: WorkoutEntity)

    @Query("DELETE FROM workouts WHERE id = :id")
    suspend fun deleteWorkoutById(id: String)
}