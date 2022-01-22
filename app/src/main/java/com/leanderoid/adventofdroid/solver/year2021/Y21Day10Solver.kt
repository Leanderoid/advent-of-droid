package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y21Day10Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    private val openCloseMap = mapOf(
        '[' to ']',
        '(' to ')',
        '{' to '}',
        '<' to '>',
    )

    fun solve(stream: InputStream): Int {
        val lines = FileUtils.streamToList(stream)

        val allErrors = mutableListOf<Char>()

        lines.forEach { line ->
            val (_, error) =
                calcOpenedChunksAndIfError(line, openCloseMap)

            error?.let {
                allErrors.add(error)
            }
        }

        val pointsMap = mapOf(
            ']' to 57,
            ')' to 3,
            '}' to 1197,
            '>' to 25137
        )

        return allErrors.fold(0) { acc, it -> acc + pointsMap[it]!! }
    }

    fun solvePart2(stream: InputStream): Long {
        val lines = FileUtils.streamToList(stream)

        val pointsMap = mapOf(
            ')' to 1,
            ']' to 2,
            '}' to 3,
            '>' to 4,
        )

        val scoreList = mutableListOf<Long>()

        lines.forEach { line ->

            val (openedChunks, error) =
                calcOpenedChunksAndIfError(line, openCloseMap)

            if (error == null) {
                scoreList.add(
                    openedChunks
                        .reversed()
                        .fold(0) { acc, it -> (acc * 5) + pointsMap[openCloseMap[it]]!! }
                )
            }
        }

        return scoreList.sorted()[scoreList.size/2]
    }

    private fun calcOpenedChunksAndIfError(
        line: String,
        openCloseMap: Map<Char, Char>
    ): Pair<ArrayDeque<Char>, Char?> {
        val opened = ArrayDeque<Char>()

        var error: Char? = null

        for (ch in line) {
            val currentCorrectCloser = if (opened.isNotEmpty()) openCloseMap[opened.last()]!! else ' '

            val forbidden = openCloseMap.values.toMutableSet().apply {
                remove(currentCorrectCloser)
            }

            if (forbidden.contains(ch)) {
                error = ch
                break
            }

            if (ch == currentCorrectCloser) {
                opened.removeLast()
            } else opened.addLast(ch)
        }

        return Pair(opened, error)
    }
}
