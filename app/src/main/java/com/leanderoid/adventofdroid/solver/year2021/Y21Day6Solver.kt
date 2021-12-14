package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y21Day6Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    fun solvePart2(stream: InputStream): Long {
        return calcLanternFish(stream, 256)
    }

    fun solve(stream: InputStream): Long {
        return calcLanternFish(stream, 80)
    }

    private fun calcLanternFish(stream: InputStream, nrOfDays: Int): Long {
        val list = FileUtils.streamToList(stream)[0].splitToSequence(",").map(String::toInt).toList()

        val all = calcDaysMoreEfficient(nrOfDays, list)
        // val all = calcForDays(nrOfDays, list)

        return all
    }

    private fun calcDaysMoreEfficient(days: Int, input: List<Int>): Long {
        val timerArray = LongArray(9) { 0L }
        input.forEach { timerArray[it] += 1L }

        repeat(days) {
            val newFish = timerArray[0]
            (0..7).forEach { timerArray[it] = timerArray[it+1] }
            timerArray[6] += newFish
            timerArray[8] = newFish
        }

        return timerArray.sum()
    }

    private fun calcDays(
        nrOfDays: Int,
        list: List<Int>
    ) = (1..nrOfDays).foldIndexed(list) { index, acc, timer ->
        val newFish = mutableListOf<Int>()
        val newAcc = acc.map {
            if (it == 0) {
                newFish.add(8)
                6
            } else it - 1
        }
        val total = newAcc + newFish

        total
    }
}