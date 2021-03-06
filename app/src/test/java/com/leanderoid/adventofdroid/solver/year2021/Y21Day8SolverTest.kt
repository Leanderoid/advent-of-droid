package com.leanderoid.adventofdroid.solver.year2021

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert
import org.junit.Test

class Y21Day8SolverTest {

    @Test
    fun part1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day8testinput.txt".toInputStream()

        // Act
        val value = Y21Day8Solver().solve(inputStream)

        // Assert
        Assert.assertEquals(26, value)
    }

    @Test
    fun part1() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day8.txt".toInputStream()

        // Act
        val value = Y21Day8Solver().solve(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(330, value)
    }

    @Test
    fun part2_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day8testinput.txt".toInputStream()

        // Act
        val value = Y21Day8Solver().solvePart2(inputStream)

        // Assert
        Assert.assertEquals(61229, value)
    }

    @Test
    fun part2() {
        // Arrange
        val inputStream = "src/main/assets/data/year2021/day8.txt".toInputStream()

        // Act
        val value = Y21Day8Solver().solvePart2(inputStream)

        // Assert
        println("value: $value")
        Assert.assertEquals(1010472, value)
    }
}