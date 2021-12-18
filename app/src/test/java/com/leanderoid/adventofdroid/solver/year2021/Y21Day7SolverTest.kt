package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day7SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day7testinput.txt".toInputStream()

        // Act
        val value = Y21Day7Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(37, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day7.txt".toInputStream()

        // Act
        val value = Y21Day7Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(335330, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day7testinput.txt".toInputStream()

        // Act
        val value = Y21Day7Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(168, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day7.txt".toInputStream()

        // Act
        val value = Y21Day7Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(92439766, value)
    }
}