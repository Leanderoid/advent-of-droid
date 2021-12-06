package com.leanderoid.adventofdroid.data

import android.content.Context
import com.leanderoid.adventofdroid.R
import com.leanderoid.adventofdroid.ui.SolverData
import com.leanderoid.adventofdroid.utils.FileUtils
import com.leanderoid.adventofdroid.year2020.Day1Solver
import com.leanderoid.adventofdroid.year2020.Day2Solver

class SolverRepository(context: Context) {

    val solvers = listOf(
        SolverData(
            title = "Day1 p1, test data",
            description = "Find two values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { Day1Solver().solveAndFormat(FileUtils.getFile(context, "data/year2020/day1testinput.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverData(
            title = "Day1 p1, real data",
            description = "Find two values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { Day1Solver().solveAndFormat(FileUtils.getFile(context, "data/year2020/day1.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverData(
            title = "Day1 p2, test data",
            description = "Find three values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { Day1Solver().solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day1testinput.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverData(
            title = "Day1 p2, real data",
            description = "Find three values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { Day1Solver().solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day1.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverData(
            title = "Day2 p1, real data",
            description = "How many passwords are valid?",
            invokeSolver = { Day2Solver().solveAndFormat(FileUtils.getFile(context, "data/year2020/day2.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverData(
            title = "Day2 p2, real data",
            description = "How many passwords are valid?",
            invokeSolver = { Day2Solver().solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day2.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
    )
}