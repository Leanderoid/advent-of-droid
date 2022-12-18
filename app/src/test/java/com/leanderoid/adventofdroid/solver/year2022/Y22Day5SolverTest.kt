package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.DaySolverTest.executeTests
import org.junit.Test

class Y22Day5SolverTest {

    @Test
    fun runAllTests() {
        executeTests(
            year = "22",
            day = "5",
            expectedTestPart1 = "CMZ",
            expectedPart1 = "VRWBSFZWM",
            expectedTestPart2 = "MCD",
            expectedPart2 = "RBTWJWMCF",
        )
    }
}
