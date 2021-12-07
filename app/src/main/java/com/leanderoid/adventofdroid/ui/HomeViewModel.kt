package com.leanderoid.adventofdroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leanderoid.adventofdroid.ObjectGraph
import com.leanderoid.adventofdroid.data.SolverRepository

class HomeViewModel(
    private val solverRepository: SolverRepository = ObjectGraph.solverRepository
) : ViewModel() {

    // Get all solvers from repo and introducing the lifecycle aware viewModelScope for coroutines
    fun getSolvers() = solverRepository.solverManagers.map {
        it.coroutineScope = viewModelScope
        it
    }
}