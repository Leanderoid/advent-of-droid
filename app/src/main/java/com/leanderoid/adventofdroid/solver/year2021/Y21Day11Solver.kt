package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.InputStream

class Y21Day11Solver : Solver {
    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    data class Octopus(var energy: Int, var flashed: Boolean)

    fun solve(stream: InputStream): Int {
        val lines = FileUtils.streamToList(stream)

        val octMap = lines.map { y -> y.map { x -> Octopus(x.toString().toInt(), false) } }.toMutableList()

        var numberOfFlashes = 0
        for (step in 0..99) {
            numberOfFlashes += calcNumberOfFlashes(step, octMap)
        }

        println("numberOfFlashed: $numberOfFlashes")
        return numberOfFlashes
    }

    private fun calcNumberOfFlashes(
        step: Int,
        octMap: MutableList<List<Octopus>>,
    ): Int {
        var numberOfFlashes1 = 0
        println("step $step")
        octMap.forEach { y -> y.forEach { x -> x.flashed = false } }

        val toBeFlashedIndexList = mutableSetOf<Pair<Int, Int>>()

        octMap.indices.forEach { y ->
            octMap[y].indices.forEach { x ->
                print(octMap[y][x].energy)
                octMap[y][x].energy = calcNewValue(octMap[y][x].energy)
                if (octMap[y][x].energy == 0) toBeFlashedIndexList.add(Pair(y, x))
            }
            println("")
        }

        while (toBeFlashedIndexList.isNotEmpty()) {
            println(toBeFlashedIndexList)
            val (y, x) = toBeFlashedIndexList.first()
            println("investigating: $y, $x")
            octMap[y][x].flashed = true
            numberOfFlashes1++
            toBeFlashedIndexList.remove(Pair(y, x))

            for (yc in y - 1..y + 1) {
                for (xc in x - 1..x + 1) {
                    increaseSurroundingAndAddToBeFlashed(yc, xc, octMap, toBeFlashedIndexList)
                }
            }
        }
        println(toBeFlashedIndexList)
        return numberOfFlashes1
    }

    private fun increaseSurroundingAndAddToBeFlashed(
        yc: Int,
        xc: Int,
        octMap: MutableList<List<Octopus>>,
        toBeFlashedIndexList: MutableSet<Pair<Int, Int>>
    ) {
        if (yc in 0..9 && xc in 0..9 && !octMap[yc][xc].flashed) {
            if (octMap[yc][xc].energy != 0) octMap[yc][xc].energy = calcNewValue(octMap[yc][xc].energy)

            if (octMap[yc][xc].energy == 0) toBeFlashedIndexList.add(Pair(yc, xc))
        }
    }

    private fun calcNewValue(old: Int): Int {
        return if (old in 0..8) old + 1 else 0
    }

    private fun solvePart2(stream: InputStream): Int {
        return -1
    }
}
