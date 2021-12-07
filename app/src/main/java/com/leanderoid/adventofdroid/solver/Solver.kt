package com.leanderoid.adventofdroid.solver

import java.io.InputStream

interface Solver {
    fun solveAndFormat(stream: InputStream): String
    fun solveAndFormatPart2(stream: InputStream): String
}