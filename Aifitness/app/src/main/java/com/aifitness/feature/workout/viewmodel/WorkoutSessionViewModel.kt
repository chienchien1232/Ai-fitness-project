package com.aifitness.feature.workout.viewmodel
import com.aifitness.domain.model.WorkoutSessionState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aifitness.domain.model.Workout
import com.aifitness.domain.repository.WorkoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutSessionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: WorkoutRepository
) : ViewModel() {

    private val workoutId =
        checkNotNull(savedStateHandle.get<String>("workoutId"))

    private val _workout = MutableStateFlow<Workout?>(null)
    val workout: StateFlow<Workout?> = _workout

    private val _session =
        MutableStateFlow(
            WorkoutSessionState()
        )
    val session: StateFlow<WorkoutSessionState> = _session

    init {
        loadWorkout()
    }

    private fun loadWorkout() {
        viewModelScope.launch {
            _workout.value =
                repository.getWorkoutById(workoutId)
        }
    }

    fun nextRep() {
        val workout = _workout.value ?: return
        val currentExercise = workout.exercises[_session.value.currentExerciseIndex]
        val targetReps = currentExercise.reps ?: 10

        if (_session.value.currentRep < targetReps - 1) {
            _session.value = _session.value.copy(
                currentRep = _session.value.currentRep + 1
            )
        } else {
            nextExercise()
        }
    }

    fun nextExercise() {
        val workout = _workout.value ?: return
        if (_session.value.currentExerciseIndex < workout.exercises.size - 1) {
            _session.value = _session.value.copy(
                currentExerciseIndex = _session.value.currentExerciseIndex + 1,
                currentRep = 0,
                currentSet = 1
            )
        } else {
            finishWorkout()
        }
    }

    fun finishWorkout() {
        _session.value = _session.value.copy(
            isCompleted = true
        )
    }
}