package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day2SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day2testinput.txt".toInputStream()

        // Act
        val value = Y21Day2Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(150, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day2.txt".toInputStream()

        // Act
        val value = Y21Day2Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(2322630, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day2testinput.txt".toInputStream()

        // Act
        val value = Y21Day2Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(900, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day2.txt".toInputStream()

        // Act
        val value = Y21Day2Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(2105273490, value)
    }
}