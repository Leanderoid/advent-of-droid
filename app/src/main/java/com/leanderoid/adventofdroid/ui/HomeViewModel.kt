package com.leanderoid.adventofdroid.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leanderoid.adventofdroid.ObjectGraph
import com.leanderoid.adventofdroid.solver.SolverRepository
import com.leanderoid.adventofdroid.solver.SolverStateManager
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val solverRepository: SolverRepository = ObjectGraph.solverRepository
) : ViewModel() {

    private val selectedCategory = MutableStateFlow(HomeCategory.Year2020)
    private val categories = MutableStateFlow(HomeCategory.values().asList())
    private val solvers = MutableStateFlow(initSolvers(solverRepository.solverManagers2020))

    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            combine(
                categories,
                selectedCategory,
                solvers,
            ) { categories, selectedCategory, solvers ->
                HomeViewState(
                    homeCategories = categories,
                    selectedHomeCategory = selectedCategory,
                    solvers = solvers,
                )
            }.catch {
                throw it
            }.collect {
                _state.value = it
            }
        }
    }

    fun onHomeCategorySelected(category: HomeCategory) {
        selectedCategory.value = category
        solvers.value = when (category) {
            HomeCategory.Year2020 -> initSolvers(solverRepository.solverManagers2020)
            HomeCategory.Year2021 -> initSolvers(solverRepository.solverManagers2021)
        }
    }

    // Get all solvers from repo and introducing the lifecycle aware viewModelScope for coroutines
    private fun initSolvers(managers: List<SolverStateManager> ) = managers.map {
        it.apply { coroutineScope = viewModelScope }
    }
}

enum class HomeCategory {
    Year2020, Year2021
}

data class HomeViewState(
    val selectedHomeCategory: HomeCategory = HomeCategory.Year2020,
    val homeCategories: List<HomeCategory> = emptyList(),
    val solvers: List<SolverStateManager> = emptyList(),
)