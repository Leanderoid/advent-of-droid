package com.leanderoid.adventofdroid.solver.year2020

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils.streamToList
import java.io.InputStream

class Day1Solver: Solver {

    override fun solveAndFormat(stream: InputStream): String {
        val (values, product) = solve(stream)

        return "${values.first} * ${values.second} = $product"
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        val (values, product) = solvePart2(stream)

        return "${values.first} * ${values.second} * ${values.third} = $product"
    }

    fun solve(stream: InputStream): Pair<Pair<Int, Int>, Int> {
        val values = streamToList(stream).map(String::toInt)

        var result: Pair<Int, Int> = Pair(0, 0)
        run loop@{
            values.forEach Outer@{ v ->
                values.forEach { v2 ->
                    if (v + v2 == 2020) {
                        result = Pair(v, v2)
                        return@loop
                    }
                }
            }
        }

        val product = result.first * result.second
        return Pair(result, product)
    }

    fun solvePart2(stream: InputStream): Pair<Triple<Int, Int, Int>, Int> {
        val values = streamToList(stream).map(String::toInt)

        var triple: Triple<Int, Int, Int> = Triple(0,0, 0)
        run loop@{
            values.forEach Outer@{ v ->
                values.forEach { v2 ->
                    values.forEach { v3 ->
                        if (v + v2 + v3 == 2020) {
                            triple = Triple(v, v2, v3)
                            return@loop
                        }
                    }
                }
            }
        }

        return Pair(triple, triple.first * triple.second * triple.third)
    }
}