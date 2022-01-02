package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import com.leanderoid.adventofdroid.utils.Point
import java.io.InputStream

class Y21Day5Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solve(stream, true).toString()
    }

    fun solvePart2(stream: InputStream): Int {
        return solve(stream, diagonals = true)
    }

    fun solve(stream: InputStream, diagonals: Boolean = false): Int {
        val lines = FileUtils.streamToList(stream)

        // Extract line start/end points
        val lineDefList = lines.map {
            val (x1, y1, x2, y2) = """(\d+),(\d+) -> (\d+),(\d+)""".toRegex().find(it)?.destructured ?: error("error")
            Line(Point(x1.toInt(),y1.toInt()), Point(x2.toInt(), y2.toInt()))
        }

        val mapWithAppliedLines = lineDefList.fold(mutableMapOf<Point, Int>()) { acc, it ->
            when {
                it.start.x == it.end.x -> acc.applyLineToMap(calcPoints(it.start.y, it.end.y) { y: Int -> Point(it.start.x, y) } )
                it.start.y == it.end.y -> acc.applyLineToMap(calcPoints(it.start.x, it.end.x) { x: Int -> Point(x, it.start.y) } )
                else -> if (diagonals) acc.applyLineToMap(calcDiagPoints(it)) else acc
            }
        }

        return mapWithAppliedLines.values.count { it >= 2 }
    }

    private fun MutableMap<Point, Int>.applyLineToMap(points: List<Point>): MutableMap<Point, Int> {
        points.forEach { point ->
            val occurrences = this[point]
            this[point] = occurrences?.let {
                occurrences + 1
            } ?: 1
        }

        return this
    }

    private fun calcPoints(a: Int, b: Int, returnPoint: (Int) -> Point): List<Point> {
        val range = if (a < b) a..b else b..a
        return range.map { returnPoint(it) }
    }

    private fun calcDiagPoints(line: Line): List<Point> {
        val p1 = line.start
        val p2 = line.end

        val (start, end) = if (p1.x < p2.x) Pair(p1, p2) else Pair(p2, p1)

        // Always traverse from lowest x to highest, assume 45 degree angle up or down
        return (start.x..end.x).mapIndexed { i, dx ->
            val yIndex = if (start.y > end.y) -i else i
            Point(dx, start.y+yIndex)
        }
    }

    data class Line(val start: Point, val end: Point)
}