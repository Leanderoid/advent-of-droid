package com.leanderoid.adventofdroid.solver.year2020

import com.leanderoid.adventofdroid.solver.Solver
import com.leanderoid.adventofdroid.utils.FileUtils.streamToList
import java.io.InputStream

class Day2Solver : Solver {

    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    fun solve(inputStream: InputStream): Int {
        return countValidPredicates(inputStream) { first: String, second: String, str: String, psw: String ->
            psw.count { it == str[0] } in (first.toInt()..second.toInt())
        }
    }

    fun solvePart2(inputStream: InputStream): Int {
        return countValidPredicates(inputStream) { first: String, second: String, str: String, psw: String ->
            val pswContainsStrAtFirst = psw[first.toInt() - 1] == str[0]
            val pswContainsStrAtSecond = psw[second.toInt() - 1] == str[0]

            pswContainsStrAtFirst xor pswContainsStrAtSecond
        }
    }

    private fun countValidPredicates(inputStream: InputStream, predicate: (first: String, second: String, str: String, psw: String) -> Boolean): Int {
        val list = streamToList(inputStream)

        val regex = """(\d+)-(\d+) (\w): (\w+)""".toRegex()

        val count = list.count {
            val (first, second, str, psw) = regex.find(it)?.destructured ?: error("Error occurred")

            predicate(first, second, str, psw)
        }

        return count
    }
}