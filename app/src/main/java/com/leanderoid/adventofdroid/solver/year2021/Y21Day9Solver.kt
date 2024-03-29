package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import com.leanderoid.adventofdroid.utils.Point
import java.io.InputStream

class Y21Day9Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    fun solve(stream: InputStream): Int {
        val strategy = object : PointStrategy {
            private val riskList = mutableListOf<Int>()

            override fun onLowPoint(x: Int, y: Int, lines: List<String>) {
                riskList.add(lines[y][x].toInt2() + 1)
            }

            override fun calcResult(): Int {
                return riskList.sum()
            }
        }

        return calcSolution(stream, strategy)
    }

    fun solvePart2(stream: InputStream): Int {
        val strategy = object : PointStrategy {
            private val basinList = mutableListOf<Int>()

            override fun onLowPoint(x: Int, y: Int, lines: List<String>) {
                basinList.add(calcBasinSize(x, y, lines))
            }

            override fun calcResult(): Int {
                basinList.sortDescending()
                return basinList[0] * basinList[1] * basinList[2]
            }
        }

        return calcSolution(stream, strategy)
    }

    private fun calcSolution(stream: InputStream, strategy: PointStrategy): Int {
        val lines = FileUtils.streamToList(stream)

        lines.indices.forEach { y ->
            lines[y].indices.forEach { x ->
                val c = lines[y][x].toInt2()

                val lowPoint =
                    eval { lines[y][x - 1].toInt2() > c } &&
                    eval { lines[y][x + 1].toInt2() > c } &&
                    eval { lines[y + 1][x].toInt2() > c } &&
                    eval { lines[y - 1][x].toInt2() > c }

                if (lowPoint) strategy.onLowPoint(x, y, lines)
            }
        }

        return strategy.calcResult()
    }

    private fun calcBasinSize(
        x: Int,
        y: Int,
        lines: List<String>
    ): Int {
        val toCheck = mutableSetOf(Point(x, y))
        val checked = mutableSetOf<Point>()

        while (toCheck.isNotEmpty()) {
            val p = toCheck.first()
            toCheck.remove(p)

            val height = lines[p.y][p.x].toInt2()

            listOf(
                Point(p.x - 1, p.y),
                Point(p.x + 1, p.y),
                Point(p.x, p.y - 1),
                Point(p.x, p.y + 1),
            ).forEach {
                if (newPointInBasin(checked, it.x, it.y, lines, height)) toCheck.add(it)
            }

            checked.add(p)
        }

        return checked.size
    }

    private fun newPointInBasin(
        checked: MutableSet<Point>,
        x: Int,
        y: Int,
        lines: List<String>,
        height: Int,
    ): Boolean {
        if (x !in 0..lines.first().lastIndex || y !in 0..lines.lastIndex) return false

        return !checked.contains(Point(x, y)) && lines[y][x].toInt2() > height && lines[y][x].toInt2() != 9
    }

    private fun Char.toInt2(): Int {
        return this.toString().toInt()
    }

    private fun eval(tryPoint: () -> Boolean) = try {
        tryPoint()
    } catch (e: Exception) {
        true
    }

    interface PointStrategy {
        fun onLowPoint(x: Int, y: Int, lines: List<String>)
        fun calcResult(): Int
    }
}