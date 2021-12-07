package com.leanderoid.adventofdroid.solver.year2020

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import com.leanderoid.adventofdroid.solver.year2020.Day3Solver
import com.leanderoid.adventofdroid.solver.year2020.Day3SolverOld
import com.leanderoid.adventofdroid.solver.year2020.IDay3Solver
import org.junit.Assert.assertEquals
import org.junit.Test

class Day3SolverTest {

    @Test
    fun day3_testInput() {
        val inputStream = "src/main/assets/data/year2020/day3testinput.txt".toInputStream()

        val count = Day3Solver().solve(inputStream)

        assertEquals(7, count)
    }

    @Test
    fun day3() = performPart1Test(Day3Solver())

    @Test
    fun day3_part2_testInput() {
        val inputStream = "src/main/assets/data/year2020/day3testinput.txt".toInputStream()

        val product = Day3Solver().solvePart2(inputStream)

        assertEquals(336, product)
    }

    @Test
    fun day3_part2() = performPart2Test(Day3Solver())

    @Test
    fun day3_old_part2() = performPart2Test(Day3SolverOld())

    @Test
    fun day3_old() = performPart1Test(Day3SolverOld())

    private fun performPart1Test(solver: IDay3Solver) {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day3.txt".toInputStream()

        // Act
        val count = solver.solve(inputStream)

        // Assert
        assertEquals(203, count)
    }

    private fun performPart2Test(day3Solver: IDay3Solver) {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day3.txt".toInputStream()

        // Act
        val product = day3Solver.solvePart2(inputStream)

        // Assert
        println("Tree product: $product")
        assertEquals(3316272960, product)
    }
}