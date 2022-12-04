package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.DaySolverTest.executeTests
import org.junit.Test

class Y22Day1SolverTest {

    @Test
    fun runAllTests() {
        executeTests(
            year = "22",
            day = "1",
            expectedTestPart1 = "24000",
            expectedPart1 = "68787",
            expectedTestPart2 = "45000",
            expectedPart2 = "198041",
        )
    }
}