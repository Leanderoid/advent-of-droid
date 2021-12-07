package com.leanderoid.adventofdroid

import android.content.Context
import com.leanderoid.adventofdroid.solver.SolverRepository

/**
 * A simple global singleton dependency graph.
 * Replace with something like Hilt/Dagger.
 */
object ObjectGraph {
    lateinit var solverRepository: SolverRepository

    fun provide(context: Context) {
        solverRepository = SolverRepository(context)
    }
}