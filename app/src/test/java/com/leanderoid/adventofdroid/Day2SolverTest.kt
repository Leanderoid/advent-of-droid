package com.leanderoid.adventofdroid

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import com.leanderoid.adventofdroid.year2020.Day2Solver
import org.junit.Assert.assertEquals
import org.junit.Test

class Day2SolverTest {

    @Test
    fun day2_testInput() {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day2testinput.txt".toInputStream()

        // Act
        val countedLines = Day2Solver().solve(inputStream)

        // Assert
        assertEquals(2, countedLines)
    }

    @Test
    fun day2() {
        val inputStream = "src/main/assets/data/year2020/day2.txt".toInputStream()

        val countedLines = Day2Solver().solve(inputStream)

        assertEquals(580, countedLines)
    }


    @Test
    fun day2_part2_testData() {
        val inputStream = "src/main/assets/data/year2020/day2testinput.txt".toInputStream()

        val countedLines = Day2Solver().solvePart2(inputStream)

        assertEquals(1, countedLines)
    }

    @Test
    fun day2_part2() {
        val inputStream = "src/main/assets/data/year2020/day2.txt".toInputStream()

        val countedLines = Day2Solver().solvePart2(inputStream)

        assertEquals(611, countedLines)
    }
}