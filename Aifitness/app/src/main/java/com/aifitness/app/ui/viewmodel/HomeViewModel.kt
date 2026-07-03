package com.aifitness.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aifitness.domain.model.FitnessMetrics
import com.aifitness.domain.usecase.exercise.GetExercisesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

    private val getExercisesUseCase: GetExercisesUseCase

) : ViewModel() {

    val exercises = getExercisesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _fitnessMetricsState =
        MutableStateFlow(FitnessMetrics())

    val fitnessMetricsState: StateFlow<FitnessMetrics> =
        _fitnessMetricsState.asStateFlow()

    init {
        connectToWatchAndListen()
    }

    private fun connectToWatchAndListen() {
        viewModelScope.launch {
            _fitnessMetricsState.update { currentState ->
                currentState.copy(
                    calories = 520,
                    heartRate = 78,
                    steps = 6240,
                    movingMinutes = 28
                )
            }
        }
    }
}