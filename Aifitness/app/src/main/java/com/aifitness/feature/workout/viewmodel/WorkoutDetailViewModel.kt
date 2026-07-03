package com.aifitness.feature.workout.viewmodel

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
class WorkoutDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: WorkoutRepository
) : ViewModel() {

    private val _workout = MutableStateFlow<Workout?>(null)

    val workout: StateFlow<Workout?> = _workout

    init {

        val id = checkNotNull(savedStateHandle.get<String>("workoutId"))
        viewModelScope.launch {

            _workout.value =
                repository.getWorkoutById(id)

        }

    }

}