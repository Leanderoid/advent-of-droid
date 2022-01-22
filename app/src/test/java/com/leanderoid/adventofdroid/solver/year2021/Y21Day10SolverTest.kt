package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day10SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day10testinput.txt".toInputStream()

        // Act
        val value = Y21Day10Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(26397, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day10.txt".toInputStream()

        // Act
        val value = Y21Day10Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(464991, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day10testinput.txt".toInputStream()

        // Act
        val value = Y21Day10Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(288957, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day10.txt".toInputStream()

        // Act
        val value = Y21Day10Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(3662008566, value)
    }
}