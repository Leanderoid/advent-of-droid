package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y22Day3Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String = solve(stream).toString()

    override fun solveAndFormatPart2(stream: InputStream): String = solvePart2(stream).toString()

    private val pointMap: Map<Char, Int> =
        ('a'..'z').mapIndexed { index, c -> c to index + 1 }.toMap()
            .plus(
                ('A'..'Z').mapIndexed { index, c -> c to index + 27 }.toMap()
            )

    fun solve(stream: InputStream): Int = FileUtils.streamToList(stream).sumOf {
        val c1 = it.substring(0, it.length / 2)
        val c2 = it.substring(it.length / 2, it.length)
        val intersection = c1.toList().intersect(
            c2.toList().toSet()
        )

        pointMap[intersection.first().toChar()] ?: 0
    }

    fun solvePart2(stream: InputStream) = FileUtils.streamToList(stream)
        .windowed(3, 3) { group ->
            val intersection = group[0].toList().intersect(
                group[1].toList().intersect(
                    group[2].toList().toSet()
                )
            )
            pointMap[intersection.first()] ?: 0
        }.sum()
}
