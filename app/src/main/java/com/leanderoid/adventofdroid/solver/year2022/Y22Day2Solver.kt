package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y22Day2Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String = solve(stream).toString()

    override fun solveAndFormatPart2(stream: InputStream): String = solvePart2(stream).toString()

    // A, B, C
    // X, Y, Z
    // Ro, Pa, Sc
    // Rock, Paper, Scissors
    // 1, 2, 3
    // Win: 6, Draw: 3, Lose: 0
    // Points = Type + Result * n

    private val battlePoints = listOf(
        mapOf( // Rock
            0 to 3, // vs Rock
            1 to 0, // vs Paper
            2 to 6, // vs Scissors
        ),
        mapOf( // Paper
            0 to 6,
            1 to 3,
            2 to 0,
        ),
        mapOf( // Scissors
            0 to 0,
            1 to 6,
            2 to 3,
        ),
    )

    private val typePoints = mapOf(
        0 to 1,
        1 to 2,
        2 to 3,
    )

    private val codeMap = mapOf(
        'X' to 0,
        'Y' to 1,
        'Z' to 2,
        'A' to 0,
        'B' to 1,
        'C' to 2,
    )

    fun solve(stream: InputStream): Int =
        FileUtils.streamToList(stream)
            .map {
                val me = codeMap[it[2]]!!
                val them = codeMap[it[0]]!!

                battlePoints[me][them]!! + typePoints[me]!!
            }
            .sum()


    // X, Y, Z
    // Lose, Draw, Win
    private val orderPoints = listOf(0, 3, 6)

    fun solvePart2(stream: InputStream) = FileUtils.streamToList(stream)
        .map {
            val order = codeMap[it[2]]!!
            val orderPoint = orderPoints[order]
            val them = codeMap[it[0]]!!

            // .reversed() because checking from perspective of them to get it right.
            val meType = battlePoints[them].firstNotNullOf { typeRow ->
                val typeMatchesTheOrderedOutcome = typeRow.value == orderPoints.reversed()[order]
                if(typeMatchesTheOrderedOutcome) typeRow.key else null
            }

            println("them: $them, order: $orderPoint, meType: $meType, typeP: ${typePoints[meType]}")
            orderPoint + typePoints[meType]!!
        }
        .map {
            println(it)
            it
        }
        .sum()
}
