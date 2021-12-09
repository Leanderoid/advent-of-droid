package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream
import kotlin.math.pow

class Y21Day3Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    fun solve(stream: InputStream): Int {
        val lines = FileUtils.streamToList(stream)

        val gamma = lines.xIndexes().map {
            if (countInColumn(it, lines, '1') >= lines.size / 2) 1 else 0
        }

        val epsilon = gamma.flipBits()

        return gamma.toBinString().binToDecimal().toInt() * epsilon.toBinString().binToDecimal().toInt()
    }

    fun solvePart2(stream: InputStream): Int {
        val lines = FileUtils.streamToList(stream)

        val genRating = calcRating(lines) { list: List<String>, count: Int ->  count >= list.size / 2.0 }

        val scrubberRating = calcRating(lines) { list: List<String>, count: Int -> count < list.size / 2.0 }

        return genRating * scrubberRating
    }

    private fun calcRating(
        list: List<String>,
        predicate: (List<String>, Int) -> Boolean
    ): Int {
        val filteredList = list.xIndexes().fold(list) { currentList, x ->
            val count = countInColumn(x, currentList, '1')

            val ch = if (predicate(currentList, count)) 1 else 0

            val filtered = currentList.filter { line -> line[x].toString().toInt() == ch }

            if (filtered.isEmpty()) return@fold currentList

            filtered
        }

        val rating = filteredList.first()
            .map { it.toString().toInt() }
            .toBinString()
            .binToDecimal()

        return rating.toInt()
    }

    private fun List<Int>.toBinString() = map(Int::toString)
        .reduce { acc, i -> acc.plus(i) }

    private fun List<Int>.flipBits(): List<Int> = map { (it + 1) % 2 }

    private fun countInColumn(x: Int, lines: List<String>, c: Char): Int =
        lines.yIndexes().count { y -> lines[y][x] == c }

    private fun String.binToDecimal(): Double =
        reversed().foldIndexed(0.0) { i, acc, c ->
            acc + c.toString().toInt() * 2.0.pow(i)
        }

    private fun List<String>.xIndexes() = 0..first().lastIndex
    private fun List<String>.yIndexes() = 0..lastIndex
}

