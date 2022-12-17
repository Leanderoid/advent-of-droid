package com.leanderoid.adventofdroid.solver

import android.content.Context
import com.leanderoid.adventofdroid.solver.year2020.Day3Solver
import com.leanderoid.adventofdroid.solver.year2020.Y20Day1Solver
import com.leanderoid.adventofdroid.solver.year2020.Y20Day2Solver
import com.leanderoid.adventofdroid.solver.year2020.Y20Day4Solver
import com.leanderoid.adventofdroid.solver.year2021.*
import com.leanderoid.adventofdroid.solver.year2022.Y22Day1Solver
import com.leanderoid.adventofdroid.solver.year2022.Y22Day2Solver
import com.leanderoid.adventofdroid.solver.year2022.Y22Day3Solver
import com.leanderoid.adventofdroid.solver.year2022.Y22Day4Solver
import com.leanderoid.adventofdroid.utils.FileUtils

class SolverRepository(private val context: Context) {

    private val linkBase = "https://github.com/Leanderoid/advent-of-droid/blob/main/app/src/main/java/com/leanderoid/adventofdroid/solver"

    data class SolverMetaData(val solver: Solver, val description: Pair<String, String>)

    private val solver2020Map = listOf(
        SolverMetaData(Y20Day1Solver(), Pair(
            "Find three values in a list that adds up to a specific number. Multiply these values.",
            "Find three values in a list that adds up to a specific number. Multiply these values.",
        )),
        SolverMetaData(Y20Day2Solver(), Pair(
            "How many passwords are valid?",
            "How many passwords are valid?"
        )),
        SolverMetaData(Day3Solver(), Pair(
            "How many occurrences?",
            "What's the product of found values?",
        )),
        SolverMetaData(Y20Day4Solver(), Pair(
            "Read, format and check input if valid",
            "Check input against a set of validation rules",
        )),
    )

    private val solver2021Map = listOf(
        SolverMetaData(Y21Day1Solver(),Pair(
            "Find how many values in list that are higher than the previous.",
            "Find how many values in a list with averaged windows, that are higher than the previous.",
        )),
        SolverMetaData(Y21Day2Solver(),Pair(
            "Calculate direction. Multiply x and y.",
            "Calculate direction with changed rules. Multiply x and y.",
        )),
        SolverMetaData(Y21Day3Solver(),Pair(
            "Filter binary strings and convert to decimal. Multiply x and y.",
            "Advanced filtering of binary strings, convert to decimal. Multiply x and y.",
        )),
        SolverMetaData(Y21Day4Solver(),Pair(
            "Play bingo. Multiply the sum of unmarked numbers and the last drawn one.",
            "Play bingo, let last board win. Multiply the sum of unmarked numbers and the last drawn one.",
        )),
        SolverMetaData(Y21Day5Solver(),Pair(
            "Find overlapping lines on map.",
            "Find overlapping lines on map, including diagonal ones.",
        )),
        SolverMetaData(Y21Day6Solver(),Pair(
            "Calculate the number of fish after 80 days.",
            "Calculate the number of fish after 256 days.",
        )),
        SolverMetaData(Y21Day7Solver(),Pair(
            "Calculate the least possible fuel.",
            "Calculate the least possible fuel, more advanced cost function.",
        )),
        SolverMetaData(Y21Day8Solver(),Pair(
            "Calculate the number of digits 1, 4, 7 and 8.",
            "Decrypt all data, sum the output values.",
        )),
        SolverMetaData(Y21Day9Solver(), Pair(
            "Find the sum of the risk levels on all low points",
            "Find the three largest basin sizes and multiply them",
        )),
        SolverMetaData(Y21Day10Solver(), Pair(
            "Calculate errors of chunks in line and its score",
            "Calculate the correct ending of chunks and its score"
        )),
    )

    private val solver2022Map = listOf(
        SolverMetaData(
            Y22Day1Solver(),
            Pair(
                "Calculate sums of groups and find max value",
                "Calculate sums of groups and find tot value of the largest groups",
            )
        ),
        SolverMetaData(
            Y22Day2Solver(),
            Pair(
                "Calculate sum of strategy.",
                "Calculate sum of strategy.",
            )
        ),
        SolverMetaData(
            Y22Day3Solver(),
            Pair(
                "Divide elements of a list and find intersection character. Convert char to int and summarize.",
                "Split list to groups of three and find intersection char. Convert char to int and summarize",
            ),
        ),
        SolverMetaData(
            Y22Day4Solver(),
            Pair(
                "Determine if pairs of ranges fully overlap. Count occurrences",
                "Determine if pairs of ranges just overlap. Count occurrences",
            ),
        ),
    )

    val solverManagers2020 = solver2020Map.toManager("20")
    val solverManagers2021 = solver2021Map.toManager("21")
    val solverManagers2022 = solver2022Map.toManager("22")

    private fun List<SolverMetaData>.toManager(yearSpec: String) = mapIndexed { index, it ->
        fun file() = FileUtils.getFile(context,"data/year20$yearSpec/day${index + 1}.txt")

        Pair(
            SolverStateManager(
                title = "Day${index+1} p1",
                description = it.description.first,
                link = "$linkBase/year20$yearSpec/Y${yearSpec}Day${index+1}Solver.kt",
                invokeSolver = { it.solver.solveAndFormat(file()) }
            ),
            SolverStateManager(
                title = "Day${index+1} p2",
                description = it.description.second,
                link = "$linkBase/year20$yearSpec/Y${yearSpec}Day${index+1}Solver.kt",
                invokeSolver = { it.solver.solveAndFormatPart2(file()) }
            ),
        )
    }.flatMap { listOf(it.first, it.second) }
}
