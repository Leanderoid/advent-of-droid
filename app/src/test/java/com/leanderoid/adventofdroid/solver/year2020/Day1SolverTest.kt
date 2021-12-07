package com.leanderoid.adventofdroid.solver.year2020

import com.leanderoid.adventofdroid.utils.FileUtils.toInputStream
import com.leanderoid.adventofdroid.solver.year2020.Day1Solver
import org.junit.Assert.assertEquals
import org.junit.Test

class Day1SolverTest {

    /*
    * Find two values in a list that adds up to a specific number. Multiply these values.
    */
    @Test
    fun day1_testData() {
        // Arrange
        val inputStream = "src/main/assets/data/year2020/day1testinput.txt".toInputStream()

        // Act
        val (values, product) = Day1Solver().solve(inputStream)

        // Assert
        assertEquals(514579, product)
    }

    @Test
    fun day1() {
        val inputStream = "src/main/assets/data/year2020/day1.txt".toInputStream()

        val (values, product) = Day1Solver().solve(inputStream)

        assertEquals(786811, product)

        inputStream.close()
    }

    /*
    * Find three values in a list that adds up to a specific number. Multiply these values.
    */
    @Test
    fun day1_testData_part2() {
        val inputStream = "src/main/assets/data/year2020/day1testinput.txt".toInputStream()

        val (values, product) = Day1Solver().solvePart2(inputStream)

        println("values multiplied: ${values.first} * ${values.second} * ${values.third} = ${values.first * values.second * values.third} = $product")
        assertEquals(241861950, product)
    }

    @Test
    fun day1_part2() {
        val inputStream = "src/main/assets/data/year2020/day1.txt".toInputStream()

        val (values, product) = Day1Solver().solvePart2(inputStream)

        println("values multiplied: ${values.first} * ${values.second} * ${values.third} = ${values.first * values.second * values.third} = $product")
        assertEquals(199068980, product)
    }
}