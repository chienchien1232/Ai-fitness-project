package com.aifitness.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aifitness.data.local.entity.ExerciseEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercises")
    fun getAllExercises(): Flow<List<ExerciseEntity>>

    @Query("SELECT * FROM exercises WHERE id = :id")
    suspend fun getExerciseById(id: String): ExerciseEntity?

    @Query("SELECT * FROM exercises WHERE category = :category")
    suspend fun getExercisesByCategory(category: String): List<ExerciseEntity>

    @Query("""
        SELECT * FROM exercises
        WHERE name LIKE '%' || :keyword || '%'
        OR description LIKE '%' || :keyword || '%'
    """)
    suspend fun searchExercises(keyword: String): List<ExerciseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercises(exercises: List<ExerciseEntity>)

    @Update
    suspend fun updateExercise(exercise: ExerciseEntity)

    @Delete
    suspend fun deleteExercise(exercise: ExerciseEntity)

    @Query("DELETE FROM exercises WHERE id = :id")
    suspend fun deleteExerciseById(id: String)
}