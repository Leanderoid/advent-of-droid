package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.Solver
import java.io.BufferedReader
import java.io.InputStream

class Y22Day1Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String = solve(stream).toString()

    override fun solveAndFormatPart2(stream: InputStream): String = solvePart2(stream).toString()

    fun solve(stream: InputStream): Int = toSummedGroupsList(stream)
        .maxOrNull() ?: 0

    private fun toSummedGroupsList(stream: InputStream) =
        stream.bufferedReader().use(BufferedReader::readText)
            .lines().joinToString { it.ifEmpty { ":" } }
            .split(":")
            .map { row ->
                row
                    .trim()
                    .split(",")
                    .filter { it.isNotEmpty() }
                    .fold(0) { acc, s ->
                        acc + s.trim().toInt()
                    }
            }

    fun solvePart2(stream: InputStream) = toSummedGroupsList(stream)
        .sorted()
        .reversed()
        .take(3)
        .map {
            println(it)
            it
        }
        .sum()
}
