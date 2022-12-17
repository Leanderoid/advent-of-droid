package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.DaySolverTest.executeTests
import org.junit.Test

class Y22Day3SolverTest {

    @Test
    fun runAllTests() {
        executeTests(
            year = "22",
            day = "3",
            expectedTestPart1 = "157",
            expectedPart1 = "7446",
            expectedTestPart2 = "70",
            expectedPart2 = "2646",
        )
    }
}