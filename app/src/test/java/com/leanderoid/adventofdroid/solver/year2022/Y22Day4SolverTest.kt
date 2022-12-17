package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.DaySolverTest.executeTests
import org.junit.Test

class Y22Day4SolverTest {

    @Test
    fun runAllTests() {
        executeTests(
            year = "22",
            day = "4",
            expectedTestPart1 = "2",
            expectedPart1 = "644",
            expectedTestPart2 = "4",
            expectedPart2 = "926",
        )
    }
}
