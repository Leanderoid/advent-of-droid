package com.leanderoid.adventofdroid.ui

import androidx.lifecycle.ViewModel
import com.leanderoid.adventofdroid.ObjectGraph
import com.leanderoid.adventofdroid.data.SolverRepository

class HomeViewModel(
    private val solverRepository: SolverRepository = ObjectGraph.solverRepository
) : ViewModel() {

    fun getSolvers() = solverRepository.solvers
}