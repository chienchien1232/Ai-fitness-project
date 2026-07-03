package com.aifitness.data.local

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aifitness.data.local.dao.ExerciseDao
import com.aifitness.data.local.dao.WorkoutDao
import com.aifitness.data.local.seed.ExerciseSeedData
import com.aifitness.data.local.seed.WorkoutSeedData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Provider

class DatabaseCallback(
    private val exerciseDaoProvider: Provider<ExerciseDao>,
    private val workoutDaoProvider: Provider<WorkoutDao>
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            exerciseDaoProvider.get().insertExercises(ExerciseSeedData.exercises)
            workoutDaoProvider.get().insertWorkouts(WorkoutSeedData.workouts)
        }
    }
}