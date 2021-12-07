package com.leanderoid.adventofdroid.solver.year2020

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream
import kotlin.math.abs

class Day3SolverOld : Solver, IDay3Solver {

    override fun solve(stream: InputStream): Int {
        val list = FileUtils.streamToList(stream)

        val searchChar = '#'
        val stepSize = 3

        return countEncounters(list, searchChar, stepSize)
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
            .foldIndexed(1L) { index: Int, acc: Long, x_y ->
                val (right, down) = x_y

                val countEncounters = countEncounters(lines, '#', right, down)
                println("countEncounters: $countEncounters, acc: ${acc * countEncounters}, x_y: $x_y, down: $down, index: $index")
                acc * countEncounters
            }

        return product
    }

    private fun countEncounters(
        lines: List<String>,
        searchChar: Char,
        right: Int,
        down: Int = 1
    ): Int {
        val hitCounter = lines.foldIndexed(HitCounter(0, 0)) { lineIndex, acc, line ->
            val skipLine = lineIndex % down != 0

            if (skipLine)
                acc
            else {
                val newHitCount = calcHitCount(acc, line, searchChar)

                val newIndex = calcNewStepIndex(acc, right, line)

                HitCounter(newIndex, newHitCount)
            }
        }

        return hitCounter.hitCount
    }

    private fun calcNewStepIndex(
        acc: HitCounter,
        right: Int,
        line: String
    ): Int {
        val steppedIndex = acc.mapRowIndex + right
        val offset = line.lastIndex - steppedIndex

        return if (offset >= 0) steppedIndex else abs(offset) - 1
    }

    private fun calcHitCount(
        acc: HitCounter,
        line: String,
        searchChar: Char
    ): Int {
        val rowIndex = acc.mapRowIndex
        val currentIndexOnEncounter = line[rowIndex] == searchChar
        val counter = if (currentIndexOnEncounter) acc.hitCount + 1 else acc.hitCount
        println("$line $rowIndex $currentIndexOnEncounter")

        return counter
    }

    data class HitCounter(val mapRowIndex: Int, val hitCount: Int)
}