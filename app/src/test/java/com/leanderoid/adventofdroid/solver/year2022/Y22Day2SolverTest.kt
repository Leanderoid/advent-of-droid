package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.DaySolverTest.executeTests
import org.junit.Test

class Y22Day2SolverTest {

    @Test
    fun runAllTests() {
        executeTests(
            year = "22",
            day = "2",
            expectedTestPart1 = "15",
            expectedPart1 = "11150",
            expectedTestPart2 = "12",
            expectedPart2 = "8295",
        )
    }
}