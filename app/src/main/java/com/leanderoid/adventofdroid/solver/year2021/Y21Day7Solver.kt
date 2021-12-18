package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream
import kotlin.math.abs

class Y21Day7Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    fun solve(stream: InputStream): Int {
        return calcLeastFuel(stream) { pos: Int, crab: Int -> abs(pos - crab) }
    }

    /*
    * Find a cost function that matches:
    *
    * deltaPos -> fuel
    * 1 -> 1
    * 2 -> 3
    * 3 -> 6
    * 4 -> 10
    * 5 -> 15
    * 6 -> 21
    *
    * 0..deltaPos.fold(0) { acc, i -> acc + i }
    */
    fun solvePart2(stream: InputStream): Int {
        return calcLeastFuel(stream) { pos: Int, crab: Int ->
            (0..abs(pos - crab)).fold(0) { acc, stepNr -> acc + stepNr }
        }
    }

    private fun calcLeastFuel(stream: InputStream, fuelCalcStrategy: (Int, Int) -> Int): Int {
        val list =
            FileUtils.streamToList(stream).first().splitToSequence(",").toList().map(String::toInt)

        val min = list.minOrNull() ?: return -1
        val max = list.maxOrNull() ?: return -1
        val range = min..max

        val fuelCandidateList = range.map { pos ->
            list.fold(0) { acc, crab -> acc + fuelCalcStrategy(pos, crab) }
        }

        return fuelCandidateList.minOrNull() ?: -1
    }
}
