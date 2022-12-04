package com.leanderoid.adventofdroid.solver

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import org.junit.Assert

object DaySolverTest {
    fun executeTests(
        year: String,
        day: String,
        expectedTestPart1: String = "",
        expectedPart1: String = "",
        expectedTestPart2: String = "",
        expectedPart2: String = "",
    ) {
        val daySolver = "com.leanderoid.adventofdroid.solver.year20${year}.Y${year}Day${day}Solver"
        if (expectedTestPart1.isNotEmpty()) {
            part1(
                fileStr = "src/main/assets/data/year20$year/day${day}testinput.txt",
                classStr = daySolver,
                expected = expectedTestPart1,
            )
        }
        if (expectedPart1.isNotEmpty()) {
            part1(
                fileStr = "src/main/assets/data/year20$year/day${day}.txt",
                classStr = daySolver,
                expected = expectedPart1,
            )
        }
        if (expectedTestPart2.isNotEmpty()) {
            part2(
                fileStr = "src/main/assets/data/year20$year/day${day}testinput.txt",
                classStr = daySolver,
                expected = expectedTestPart2,
            )
        }
        if (expectedPart2.isNotEmpty()) {
            part2(
                fileStr = "src/main/assets/data/year20$year/day${day}.txt",
                classStr = daySolver,
                expected = expectedPart2,
            )
        }
    }

    fun part1(
        fileStr: String,
        classStr: String,
        expected: String,
    ) {
        // Arrange
        val inputStream = fileStr.toInputStream()

        // Act
        val value = (Class.forName(classStr).newInstance() as Solver)
            .solveAndFormat(inputStream)

        // Assert
        Assert.assertEquals(expected, value)
    }

    fun part2(
        fileStr: String,
        classStr: String,
        expected: String,
    ) {
        // Arrange
        val inputStream = fileStr.toInputStream()

        // Act
        val value = (Class.forName(classStr).newInstance() as Solver)
            .solveAndFormatPart2(inputStream)

        // Assert
        Assert.assertEquals(expected, value)
    }
}
