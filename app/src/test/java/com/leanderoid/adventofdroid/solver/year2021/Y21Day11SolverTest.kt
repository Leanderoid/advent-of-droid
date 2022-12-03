package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day11SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day11testinput.txt".toInputStream()

        // Act
        val value = Y21Day11Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(1656, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day11.txt".toInputStream()

        // Act
        val value = Y21Day11Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(1697, value)
    }
}
