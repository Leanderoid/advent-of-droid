package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.solver.SolverResult
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y21Day2Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String {
        val (a, b, answer) = solve(stream)
        return "$a * $b = $answer"
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        val (a, b, answer) = solvePart2(stream)
        return "$a * $b = $answer"
    }

    data class Position(val x: Int, val y: Int, val aim: Int = 0)

    fun solve(stream: InputStream): SolverResult {
        return calcDirection(stream) { type: String, amount: Int, acc: Position ->
            when (type) {
                "forward" -> Position(acc.x + amount, acc.y)
                "down" -> Position(acc.x, acc.y + amount)
                "up" -> Position(acc.x, acc.y - amount)
                else -> Position(acc.x, acc.y)
            }
        }
    }

    fun solvePart2(stream: InputStream): SolverResult {
        return calcDirection(stream) { type: String, amount: Int, acc: Position ->
            when (type) {
                "forward" -> Position(acc.x + amount, acc.y + acc.aim * amount, acc.aim)
                "down" -> Position(acc.x, acc.y, acc.aim + amount)
                "up" -> Position(acc.x, acc.y, acc.aim - amount)
                else -> Position(acc.x, acc.y)
            }
        }
    }

    private fun calcDirection(stream: InputStream, invokeStrategy: (String, Int, Position) -> Position): SolverResult {
        val lines = FileUtils.streamToList(stream)

        val regex = """(\w+) (\d+)""".toRegex()
        val position = lines.fold(Position(0, 0)) { acc: Position, line: String ->
            val (type, amount) = regex.find(line)?.destructured ?: error("")

            invokeStrategy(type, amount.toInt(), acc)
        }

        return SolverResult(position.x, position.y,position.x * position.y)
    }
}