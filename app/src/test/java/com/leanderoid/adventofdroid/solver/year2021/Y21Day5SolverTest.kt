package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day5SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day5testinput.txt".toInputStream()

        // Act
        val value = Y21Day5Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(5, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day5.txt".toInputStream()

        // Act
        val value = Y21Day5Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(4728, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day5testinput.txt".toInputStream()

        // Act
        val value = Y21Day5Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(12, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day5.txt".toInputStream()

        // Act
        val value = Y21Day5Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(17717, value)
    }
}