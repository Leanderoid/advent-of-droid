package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y21Day1Solver : Solver {

    fun solve(stream: InputStream): Int = FileUtils.streamToList(stream)
        .map(String::toInt)
        .countIncreases()

    private fun List<Int>.countIncreases(): Int = foldIndexed(0) { index, acc, elem ->
        if (index > 0 && elem > this[index - 1]) acc + 1 else acc
    }

    override fun solveAndFormat(stream: InputStream): String = solve(stream).toString()

    override fun solveAndFormatPart2(stream: InputStream): String = solvePart2(stream).toString()

    fun solvePart2(stream: InputStream): Int {
        val list = FileUtils.streamToList(stream).map(String::toInt)

        return list
            .windowed(3, 1)
            .map { it.reduce { acc, i -> acc + i } }
            .countIncreases()
    }
}