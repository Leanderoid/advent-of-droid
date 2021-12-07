package com.leanderoid.adventofdroid

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import com.leanderoid.adventofdroid.solver.year2020.Day4Solver
import org.junit.Assert.assertEquals
import org.junit.Test

class Day4SolverTest {

    @Test
    fun day4_testInput() {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day4testinput.txt".toInputStream()

        // Act
        val count = Day4Solver().solve(inputStream)

        // Assert
        assertEquals(2, count)
    }

    @Test
    fun day4() {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day4.txt".toInputStream()

        // Act
        val count = Day4Solver().solve(inputStream)

        // Assert
        assertEquals(216, count)
    }

    @Test
    fun day4_testInput_part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day4testinput.txt".toInputStream()

        // Act
        val count = Day4Solver().solvePart2(inputStream)

        // Assert
        assertEquals(2, count)
    }

    @Test
    fun day4_part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day4.txt".toInputStream()

        // Act
        val count = Day4Solver().solvePart2(inputStream)

        // Assert
        assertEquals(150, count)
    }
}