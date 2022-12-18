package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y22Day6Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String = solve(stream, 4)

    override fun solveAndFormatPart2(stream: InputStream): String = solve(stream, 14)

    fun solve(
        stream: InputStream,
        markerSize: Int,
    ): String = FileUtils.streamToList(stream)
        .first().map { it.toString() }
        .filter { it.isNotEmpty() }
        .windowed(markerSize, 1) { chunk ->
            chunk.toSet().size == markerSize
        }.indexOfFirst { it }
        .plus(markerSize).toString()
}
