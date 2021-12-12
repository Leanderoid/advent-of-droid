package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day1SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day1testinput.txt".toInputStream()

        // Act
        val value = Y21Day1Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(7, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day1.txt".toInputStream()

        // Act
        val value = Y21Day1Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(1832, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day1testinput.txt".toInputStream()

        // Act
        val value = Y21Day1Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(5, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day1.txt".toInputStream()

        // Act
        val value = Y21Day1Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(1858, value)
    }
}