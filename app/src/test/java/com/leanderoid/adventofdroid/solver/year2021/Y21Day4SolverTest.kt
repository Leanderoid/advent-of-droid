package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day4SolverTest {
    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day4testinput.txt".toInputStream()

        // Act
        val value = Y21Day4Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(4512, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day4.txt".toInputStream()

        // Act
        val value = Y21Day4Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(11774, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day4testinput.txt".toInputStream()

        // Act
        val value = Y21Day4Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(1924, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day4.txt".toInputStream()

        // Act
        val value = Y21Day4Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(4495, value)
    }
}