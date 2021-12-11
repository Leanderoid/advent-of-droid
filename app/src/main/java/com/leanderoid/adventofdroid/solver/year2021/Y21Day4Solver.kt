package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.solver.SolverResult
import java.io.BufferedReader
import java.io.InputStream

class Y21Day4Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        val (a, b, answer) = solveBingoProblem(stream)
        return "$a * $b = $answer"
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        val (a, b, answer) = solveBingoProblem(stream, useLastBoard = true)
        return "$a * $b = $answer"
    }

    fun solve(stream: InputStream): Int {
        return solveBingoProblem(stream).answer
    }

    fun solvePart2(stream: InputStream): Int {
        return solveBingoProblem(stream, useLastBoard = true).answer
    }

    private fun solveBingoProblem(stream: InputStream, useLastBoard: Boolean = false): SolverResult {
        val str = stream.bufferedReader().use(BufferedReader::readText)

        val lines = str.lines()
            .filter { it.isNotEmpty() }

        val drawnNumbers = lines[0].splitToSequence(",").map(String::toInt).toList()

        val boards = extractBoards(str)

        val bingoGameFinishRule = { board: Board ->
            if (useLastBoard) boards.count(Board::hasBingo) == boards.size else board.hasBingo
        }

        val (bingoBoardNr, lastNumber) = playBingo(drawnNumbers, boards, bingoGameFinishRule) ?: return SolverResult(0, 0,0)

        val bingoBoard = boards[bingoBoardNr]
        bingoBoard.lines.forEach { println(it) }

        val boardNumbers = bingoBoard.lines.flatten()
        val unmarkedNumbersSum = boardNumbers.fold(0) { acc, nr ->
            if (!nr.marked) acc + nr.number else acc
        }

        return SolverResult(
            unmarkedNumbersSum,
            lastNumber,
            unmarkedNumbersSum * lastNumber
        )
    }

    private fun extractBoards(str: String) = str.splitToSequence("\n\n")
        .toList()
        .drop(1)
        .map { convertToBoard(it) }

    private fun convertToBoard(str: String): Board {
        val boardList = str.lines().map {
            it.trim()
                .replace("  ", " ")
                .splitToSequence(" ")
                .toList().map{ str ->  BoardNumber(str.toInt())}
        }

        return Board(boardList)
    }

    private fun playBingo(
        drawnNumbers: List<Int>,
        boards: List<Board>,
        bingoGameFinished: (Board) -> Boolean
    ): Pair<Int, Int>? {
        for (drawn in drawnNumbers) {
            for (board in boards) {
                board.checkAndMark(drawn)

                board.calcBingo()

                if (bingoGameFinished(board)) return Pair(boards.indexOf(board), drawn)
            }
        }

        return null
    }

    class Board(val lines: List<List<BoardNumber>>, var hasBingo: Boolean = false) {
        fun calcBingo() {
            val bingoSize = lines.size

            // Bingo rows
            lines.firstOrNull { it.count(BoardNumber::marked) == bingoSize }?.let {
                hasBingo = true
                return
            }

            // Bingo columns
            lines.first().indices.firstOrNull { countInColumn(it, lines) == bingoSize }?.let {
                hasBingo = true
            }
        }

        fun checkAndMark(drawnNumber: Int) {
            lines.flatten().find { it.number == drawnNumber }?.marked = true
        }

        private fun countInColumn(x: Int, lines: List<List<BoardNumber>>): Int =
            lines.indices.count { y -> lines[y][x].marked }
    }

    data class BoardNumber(val number: Int, var marked: Boolean = false)
}