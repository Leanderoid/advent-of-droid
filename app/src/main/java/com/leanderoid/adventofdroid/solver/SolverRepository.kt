package com.leanderoid.adventofdroid.solver

import android.content.Context
import com.leanderoid.adventofdroid.R
import com.leanderoid.adventofdroid.utils.FileUtils
import com.leanderoid.adventofdroid.solver.year2020.Day1Solver
import com.leanderoid.adventofdroid.solver.year2020.Day2Solver
import com.leanderoid.adventofdroid.solver.year2020.Day3Solver
import com.leanderoid.adventofdroid.solver.year2020.Day4Solver
import com.leanderoid.adventofdroid.solver.year2021.Y21Day1Solver

class SolverRepository(context: Context) {

    // To reuse an instance on invocation
    private val solverList = listOf(
        Day1Solver(),
        Day2Solver(),
        Day3Solver(),
        Day4Solver(),
    )

    private val solver2021List = listOf(
        Y21Day1Solver(),
    )

    val solverManagers = listOf(
        SolverStateManager(
            title = "Day1 p1, test data",
            description = "Find two values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { solverList[0].solveAndFormat(FileUtils.getFile(context, "data/year2020/day1testinput.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day1 p1, real data",
            description = "Find two values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { solverList[0].solveAndFormat(FileUtils.getFile(context, "data/year2020/day1.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day1 p2, test data",
            description = "Find three values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { solverList[0].solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day1testinput.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day1 p2, real data",
            description = "Find three values in a list that adds up to a specific number. Multiply these values.",
            invokeSolver = { solverList[0].solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day1.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day2 p1, real data",
            description = "How many passwords are valid?",
            invokeSolver = { solverList[1].solveAndFormat(FileUtils.getFile(context, "data/year2020/day2.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day2 p2, real data",
            description = "How many passwords are valid?",
            invokeSolver = { solverList[1].solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day2.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day3 p1, real data",
            description = "How many occurrences?",
            invokeSolver = { solverList[2].solveAndFormat(FileUtils.getFile(context, "data/year2020/day3.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day3 p2, real data",
            description = "What's the product of found values?",
            invokeSolver = { solverList[2].solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day3.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day4 p1, real data",
            description = "Read, format and check input if valid",
            invokeSolver = { solverList[3].solveAndFormat(FileUtils.getFile(context, "data/year2020/day4.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day4 p2, real data",
            description = "Check input against a set of validation rules",
            invokeSolver = { solverList[3].solveAndFormatPart2(FileUtils.getFile(context, "data/year2020/day4.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
    )

    val solverManagers2021 = listOf(
        SolverStateManager(
            title = "Day1 p1",
            description = "Find how many values in list that are higher than the previous.",
            invokeSolver = { solver2021List[0].solveAndFormat(FileUtils.getFile(context, "data/year2021/day1.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
        SolverStateManager(
            title = "Day1 p2",
            description = "Find how many values in a list with averaged windows, that are higher than the previous.",
            invokeSolver = { solver2021List[0].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day1.txt")) },
            image = R.drawable.ic_launcher_foreground
        ),
    )
}