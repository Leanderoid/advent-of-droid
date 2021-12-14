package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day6SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day6testinput.txt".toInputStream()

        // Act
        val value = Y21Day6Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(5934, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day6.txt".toInputStream()

        // Act
        val value = Y21Day6Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(363101, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day6testinput.txt".toInputStream()

        // Act
        val value = Y21Day6Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(26984457539, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day6.txt".toInputStream()

        // Act
        val value = Y21Day6Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(1644286074024, value)
    }
}