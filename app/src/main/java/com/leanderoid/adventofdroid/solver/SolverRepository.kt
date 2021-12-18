package com.leanderoid.adventofdroid.solver

import android.content.Context
import com.leanderoid.adventofdroid.R
import com.leanderoid.adventofdroid.utils.FileUtils
import com.leanderoid.adventofdroid.solver.year2020.Day1Solver
import com.leanderoid.adventofdroid.solver.year2020.Day2Solver
import com.leanderoid.adventofdroid.solver.year2020.Day3Solver
import com.leanderoid.adventofdroid.solver.year2020.Day4Solver
import com.leanderoid.adventofdroid.solver.year2021.*

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
        Y21Day2Solver(),
        Y21Day3Solver(),
        Y21Day4Solver(),
        Y21Day5Solver(),
        Y21Day6Solver(),
        Y21Day7Solver(),
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
        ),
        SolverStateManager(
            title = "Day1 p2",
            description = "Find how many values in a list with averaged windows, that are higher than the previous.",
            invokeSolver = { solver2021List[0].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day1.txt")) },
        ),
        SolverStateManager(
            title = "Day2 p1",
            description = "Calculate direction. Multiply x and y.",
            invokeSolver = { solver2021List[1].solveAndFormat(FileUtils.getFile(context, "data/year2021/day2.txt")) },
        ),
        SolverStateManager(
            title = "Day2 p2",
            description = "Calculate direction with changed rules. Multiply x and y.",
            invokeSolver = { solver2021List[1].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day2.txt")) },
        ),
        SolverStateManager(
            title = "Day3 p1",
            description = "Filter binary strings and convert to decimal. Multiply x and y.",
            invokeSolver = { solver2021List[2].solveAndFormat(FileUtils.getFile(context, "data/year2021/day3.txt")) },
        ),
        SolverStateManager(
            title = "Day3 p2",
            description = "Advanced filtering of binary strings, convert to decimal. Multiply x and y.",
            invokeSolver = { solver2021List[2].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day3.txt")) },
        ),
        SolverStateManager(
            title = "Day4 p1",
            description = "Play bingo. Multiply the sum of unmarked numbers and the last drawn one.",
            invokeSolver = { solver2021List[3].solveAndFormat(FileUtils.getFile(context, "data/year2021/day4.txt")) },
        ),
        SolverStateManager(
            title = "Day4 p2",
            description = "Play bingo, let last board win. Multiply the sum of unmarked numbers and the last drawn one.",
            invokeSolver = { solver2021List[3].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day4.txt")) },
        ),
        SolverStateManager(
            title = "Day5 p1",
            description = "Find overlapping lines on map.",
            invokeSolver = { solver2021List[4].solveAndFormat(FileUtils.getFile(context, "data/year2021/day5.txt")) },
        ),
        SolverStateManager(
            title = "Day5 p2",
            description = "Find overlapping lines on map, including diagonal ones.",
            invokeSolver = { solver2021List[4].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day5.txt")) },
        ),
        SolverStateManager(
            title = "Day6 p1",
            description = "Calculate the number of fish after 80 days.",
            invokeSolver = { solver2021List[5].solveAndFormat(FileUtils.getFile(context, "data/year2021/day6.txt")) },
        ),
        SolverStateManager(
            title = "Day6 p2",
            description = "Calculate the number of fish after 256 days.",
            invokeSolver = { solver2021List[5].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day6.txt")) },
        ),
        SolverStateManager(
            title = "Day7 p1",
            description = "Calculate the least possible fuel.",
            invokeSolver = { solver2021List[6].solveAndFormat(FileUtils.getFile(context, "data/year2021/day7.txt")) },
        ),
        SolverStateManager(
            title = "Day7 p2",
            description = "Calculate the least possible fuel, more advanced cost function.",
            invokeSolver = { solver2021List[6].solveAndFormatPart2(FileUtils.getFile(context, "data/year2021/day7.txt")) },
        ),
    )
}