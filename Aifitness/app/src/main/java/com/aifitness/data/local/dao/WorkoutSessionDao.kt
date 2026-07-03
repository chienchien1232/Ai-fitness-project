package com.aifitness.data.local.dao

import androidx.room.*
import com.aifitness.data.local.entity.WorkoutSessionEntity

@Dao
interface WorkoutSessionDao {

    @Query("SELECT * FROM workout_sessions")
    suspend fun getAllSessions(): List<WorkoutSessionEntity>

    @Query("SELECT * FROM workout_sessions WHERE id = :id")
    suspend fun getSessionById(id: String): WorkoutSessionEntity?

    @Query("SELECT * FROM workout_sessions WHERE workoutId = :workoutId")
    suspend fun getSessionsByWorkout(workoutId: String): List<WorkoutSessionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: WorkoutSessionEntity)

    @Update
    suspend fun updateSession(session: WorkoutSessionEntity)

    @Delete
    suspend fun deleteSession(session: WorkoutSessionEntity)

    @Query("DELETE FROM workout_sessions WHERE id = :id")
    suspend fun deleteSessionById(id: String)
}