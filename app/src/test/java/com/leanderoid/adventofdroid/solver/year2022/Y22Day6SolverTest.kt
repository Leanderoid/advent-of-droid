package com.leanderoid.adventofdroid.solver.year2022

import com.leanderoid.adventofdroid.solver.DaySolverTest.executeTests
import org.junit.Test

class Y22Day6SolverTest {

    @Test
    fun runAllTests() {
        executeTests(
            year = "22",
            day = "6",
            expectedTestPart1 = "7",
            expectedPart1 = "1566",
            expectedTestPart2 = "19",
            expectedPart2 = "2265",
        )
    }
}
