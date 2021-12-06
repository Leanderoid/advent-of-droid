package com.leanderoid.adventofdroid.data

import java.io.InputStream

interface Solver {
    fun solveAndFormat(stream: InputStream): String
    fun solveAndFormatPart2(stream: InputStream): String
}