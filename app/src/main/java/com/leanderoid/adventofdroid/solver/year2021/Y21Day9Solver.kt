package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y21Day9Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        TODO("Not yet implemented")
    }

    fun solve(stream: InputStream): Int {
        val lines = FileUtils.streamToList(stream)

        val sum = lines.indices.fold(0) { acc, y ->
            val lineResult = lines[y].indices.fold(0) { accX, x ->
                val c = lines[y][x].toInt2()

                val lowPoint =
                    eval { lines[y][x - 1].toInt2() > c } &&
                    eval { lines[y][x + 1].toInt2() > c } &&
                    eval { lines[y + 1][x].toInt2() > c } &&
                    eval { lines[y - 1][x].toInt2() > c }

                if (lowPoint) accX + c + 1 else accX
            }

            acc + lineResult
        }

        return sum
    }

    private fun Char.toInt2(): Int {
        return this.toString().toInt()
    }

    private fun eval(tryLowLeft: () -> Boolean) = try {
        tryLowLeft()
    } catch (e: Exception) {
        true
    }
}