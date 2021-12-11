package com.leanderoid.adventofdroid.solver

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SolverStateManager(
    val invokeSolver: () -> String,
    val title: String = "Title",
    val description: String = "Description",
    val image: Int = com.leanderoid.adventofdroid.R.drawable.ic_launcher_foreground
) {
    // Set this as a lifecycle aware scope
    lateinit var coroutineScope: CoroutineScope

    private var _isExpanded = MutableStateFlow(false)
    val isExpanded: StateFlow<Boolean>
        get() = _isExpanded

    fun toggleExpanded() {
        _isExpanded.value = !_isExpanded.value
    }

    private var solutionCalculated = false

    private val _solutionState = MutableStateFlow("-")
    val solutionState: StateFlow<String>
        get() = _solutionState

    fun calcSolution() {
        if (solutionCalculated) return
        solutionCalculated = true
        _solutionState.value = "Calculating..."

        coroutineScope.launch {
            _solutionState.value = "Ans: ${invokeSolver()}"
        }
    }
}