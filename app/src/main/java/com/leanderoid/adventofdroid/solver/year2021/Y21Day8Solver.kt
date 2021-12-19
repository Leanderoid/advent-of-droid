package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import java.io.InputStream

class Y21Day8Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    fun solve(stream: InputStream): Int {
        val txt = stream.bufferedReader().use { it.readText() }

        val approvedLengthList = arrayListOf(2, 3, 4, 7)

        val lines = txt.replace("|\n", "| ").lines()

        val outputCandidateList = lines.map {
            """(\|).*""".toRegex().find(it)?.value?.replace("|", "")?.trim()?.splitToSequence(" ")?.toList() ?: error("")
        }

        return outputCandidateList
            .flatten()
            .count { approvedLengthList.contains(it.length) }
    }

    data class NumberData(val pattern: MutableMap<String, Int>, var output: List<Pair<String, Int>>)

    fun solvePart2(stream: InputStream): Int {
        val txt = stream.bufferedReader().use { it.readText() }

        val lines = txt.replace("|\n", "| ").lines()

        val partialDataList = lines.map { line ->
            val splitLine = line.split("|")

            NumberData(
                pattern = splitLine.first().toPopulatedSequence().toMap().toMutableMap(),
                output = splitLine.last().toPopulatedSequence().toList(),
            )
        }

        val completedDataList = partialDataList.map { decryptRemainingNumberData(it) }

        return completedDataList
            .map { createNumberFromInts(it) }
            .sum()
    }

    private fun createNumberFromInts(data: NumberData) =
        data.output
            .fold("") { acc, n -> acc + n.second.toString() }
            .toInt()

    private fun decryptRemainingNumberData(data: NumberData): NumberData {
        val decryptedData = data.copy()
        val pattern = decryptedData.pattern.toMap()

        decryptedData.pattern.forEach { entry ->
            decryptedData.pattern[entry.key] = when (entry.key.length) {
                5 -> findTwoThreeFive(entry.key, pattern)
                6 -> findZeroSixNine(entry.key, pattern)
                else -> entry.value
            }
        }

        decryptedData.output = decryptedData.output.map { entry ->
            val second = when (entry.first.length) {
                5, 6 -> decryptedData.pattern[calcOutputNumber(decryptedData, entry)] ?: entry.second
                else -> entry.second
            }

            Pair(entry.first, second)
        }.toList()

        return decryptedData
    }

    private fun calcOutputNumber(
        data: NumberData,
        entry: Pair<String, Int>
    ) = data.pattern.keys
        .filter { it.length == entry.first.length }
        .first { key -> entry.first.toList()
            .count { c -> key.contains(c) } == entry.first.length
        }

    private fun setNumberByLength(length: Int) = when (length) {
        2 -> 1
        3 -> 7
        4 -> 4
        7 -> 8
        else -> -1
    }

    private fun nrIntersectingSegments(key: String, it: String) =
        key.toList().intersect(it.toSet()).size

    private fun findTwoThreeFive(key: String, pattern: Map<String, Int>): Int {
        val rMap = reverseMap(pattern)

        if (rMap[7]?.let { nrIntersectingSegments(key, it) } == 3) return 3
        if (rMap[4]?.let { nrIntersectingSegments(key, it) } == 3) return 5
        return 2
    }

    private fun findZeroSixNine(key: String, pattern: Map<String, Int>): Int {
        val rMap = reverseMap(pattern)

        if (rMap[4]?.let { nrIntersectingSegments(key, it) } == 4) return 9
        if (rMap[7]?.let { nrIntersectingSegments(key, it) } == 3) return 0
        return 6
    }

    private fun reverseMap(all: Map<String, Int>) =
        all.entries.associate { (k, v) -> v to k }

    private fun String.toPopulatedSequence() = trim()
        .splitToSequence(" ")
        .map { it to setNumberByLength(it.length) }
}
