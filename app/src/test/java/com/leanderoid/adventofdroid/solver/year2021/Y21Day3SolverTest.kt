package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day3SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day3testinput.txt".toInputStream()

        // Act
        val value = Y21Day3Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(198, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day3.txt".toInputStream()

        // Act
        val value = Y21Day3Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(3885894, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day3testinput.txt".toInputStream()

        // Act
        val value = Y21Day3Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(230, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day3.txt".toInputStream()

        // Act
        val value = Y21Day3Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(4375225, value)
    }
}