package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y22Day4Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String = solve(stream).toString()

    override fun solveAndFormatPart2(stream: InputStream): String = solvePart2(stream).toString()

    fun solve(stream: InputStream): Int = FileUtils.streamToList(stream).count { row ->
        val (a, b) = row.split(',')

        val intersectSize = a.intersectSize(b)

        intersectSize == a.toRange().count() || intersectSize == b.toRange().count()
    }

    fun solvePart2(stream: InputStream) = FileUtils.streamToList(stream).count { row ->
        val (a, b) = row.split(',')

        a.intersectSize(b) > 0
    }

    private fun String.intersectSize(b: String) = toRange().intersect(b.toRange()).size

    private fun String.toRange(): IntRange {
        val (first, last) = split('-')
        return first.toInt()..last.toInt()
    }
}
