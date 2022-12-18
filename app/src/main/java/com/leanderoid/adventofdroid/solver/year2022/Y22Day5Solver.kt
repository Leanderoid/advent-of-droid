package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y22Day5Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String = solve(stream, ::moveStrategy)

    override fun solveAndFormatPart2(stream: InputStream): String = solve(stream, ::moveStrategyReversed)

    fun solve(
        stream: InputStream,
        moveStrategy: (List<List<Char>>, Int, String) -> List<Char>,
    ): String {
        val rawList = FileUtils.streamToList(stream)

        val algoStartIndex = rawList.indexOfFirst { it.contains("move") }

        val nrOfColumns = rawList[algoStartIndex-1][rawList.first().lastIndex-1].toString().toInt()

        val updatedLetterMap = performAlgorithm(
            letterMap = calcLetterMap(nrOfColumns, rawList, algoStartIndex),
            algoList = rawList.subList(algoStartIndex, rawList.size),
            moveStrategy = moveStrategy,
        )

        return updatedLetterMap.map { it.firstOrNull() ?: "" }.joinToString(",").filter { it != ',' }
    }

    private fun performAlgorithm(
        letterMap: MutableList<MutableList<Char>>,
        algoList: List<String>,
        moveStrategy: (List<List<Char>>, Int, String) -> List<Char>,
    ): MutableList<MutableList<Char>> {
        algoList.forEach { row ->
            val regex = """(\w+) (\d+) (\w+) (\d+) (\w+) (\d+)""".toRegex()
            val (_, amount, _, from, _, to) = regex.find(row)?.destructured ?: error("")

            val fromInd = from.toInt() - 1
            val toInd = to.toInt() - 1

            val movedElements = moveStrategy(letterMap, fromInd, amount)

            val leftOver = letterMap[fromInd].drop(amount.toInt())
            letterMap[fromInd] = leftOver.toMutableList()

            letterMap[toInd] = letterMap[toInd]
                .reversed()
                .toMutableList()
                .plus(movedElements)
                .reversed()
                .toMutableList()
        }

        return letterMap
    }

    private fun calcLetterMap(
        nrOfColumns: Int,
        list: List<String>,
        algoStartIndex: Int,
    ): MutableList<MutableList<Char>> {
        val letterMap = (0 until nrOfColumns).map { mutableListOf<Char>() }.toMutableList()

        list.subList(0, algoStartIndex - 1)
            .forEach { row ->
                (0 until nrOfColumns).forEach { col ->
                    val x = 1 + (col * 4)
                    if (row[x] != ' ') letterMap[col].add(row[x])
                }
            }

        return letterMap
    }

    private fun moveStrategy(
        letterList: List<List<Char>>,
        fromInd: Int,
        amount: String,
    ) = letterList[fromInd].take(amount.toInt())

    private fun moveStrategyReversed(
        letterList: List<List<Char>>,
        fromInd: Int,
        amount: String,
    ) = letterList[fromInd].take(amount.toInt()).reversed()
}
