package com.leanderoid.adventofdroid.ui

data class SolverData(
    val invokeSolver: () -> String,
    val title: String = "Title",
    val description: String = "Description",
    val image: Int = com.leanderoid.adventofdroid.R.drawable.ic_launcher_foreground
) {
    val msg: String by lazy { invokeSolver() }

}