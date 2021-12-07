package com.leanderoid.adventofdroid.solver.year2020

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

interface IDay3Solver {
    fun solve(stream: InputStream): Int
    fun solvePart2(stream: InputStream): Long
}

class Day3Solver : Solver, IDay3Solver {

    override fun solve(stream: InputStream): Int {
        val list = FileUtils.streamToList(stream)

        val searchChar = '#'
        val stepSize = 3

        return countOccurrences(list, searchChar, stepSize)
    }

    /*
    * Relationship for slope variable:
    * dx/dy = x/y
    * y = x / (dx/dy) = x * dy/dx
    * x = y * (dx/dy)
    *
    */
    private fun countOccurrences(
        lines: List<String>,
        searchChar: Char,
        dx: Int,
        dy: Int = 1
    ): Int {
        val width = lines[0].length
        return lines.indices.count { y ->
            val slope = dx.toDouble() / dy.toDouble()
            val x = (y * slope).toInt() % width
            val shouldCountThisLine = y % dy == 0

            shouldCountThisLine && lines[y][x] == searchChar
        }
    }

    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    override fun solvePart2(stream: InputStream): Long {
        val lines = FileUtils.streamToList(stream)

        val stepMap = listOf(
            1 to 1,
            3 to 1,
            5 to 1,
            7 to 1,
            1 to 2
        )

        val product = stepMap
            .map {
                countOccurrences(lines, searchChar = '#', dx = it.first, dy = it.second).toLong()
            }
            .reduce { acc, i -> acc * i }
        return product
    }
}