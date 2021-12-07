package com.leanderoid.adventofdroid.year2020

import com.leanderoid.adventofdroid.data.Solver
import com.leanderoid.adventofdroid.utils.FileUtils
import java.io.BufferedReader
import java.io.InputStream

class Day4Solver : Solver {

    fun solve(stream: InputStream): Int {
        val str = stream.bufferedReader().use(BufferedReader::readText)
        val passPortList = extractPassPortListFromText(str)

        val count = passPortList.count { it.isValidPassPort() }
        println("Valid passports, count: $count of a total of: ${passPortList.size}")
        return count
    }

    override fun solveAndFormat(stream: InputStream): String {
        return solve(stream).toString()
    }

    override fun solveAndFormatPart2(stream: InputStream): String {
        return solvePart2(stream).toString()
    }

    private fun extractPassPortListFromText(lines: String): List<PassPort> {
        val passPortDataList = lines
            .replace("\n\n", "+++")
            .replace("\n", " ")
            .replace("+++", "\n")
            .lines()

        val passPortList = passPortDataList.map {
            PassPort(
                extractField("byr", it),
                extractField("iyr", it),
                extractField("eyr", it),
                extractField("hgt", it),
                extractField("hcl", it),
                extractField("ecl", it),
                extractField("pid", it),
                extractField("cid", it)
            )
        }
        return passPortList
    }

    private fun extractField(fieldName: String, line: String) = """(?<=$fieldName:).*""".toRegex().find(line)?.value?.substringBefore(" ")

    private fun PassPort.isValidPassPort() = listOf(byr, iyr, eyr, hgt, hcl, ecl, pid).all { it != null }

    private fun PassPort.isValidPassPortPart2(): Boolean {
        return byr?.toIntOrNull() in 1920..2002 &&
            iyr?.toIntOrNull() in 2010..2020 &&
            eyr?.toIntOrNull() in 2020..2030 &&
            hgt != null && validHeight(hgt) &&
            hcl != null && validHairColor(hcl) &&
            ecl != null && validEyeColor(ecl) &&
            pid != null && validPid(pid)
    }

    private fun validPid(pid: String): Boolean {
        return pid.length == 9 && pid.toIntOrNull() != null
    }

    private fun validEyeColor(ecl: String): Boolean = """amb|blu|brn|gry|grn|hzl|oth""".toRegex().find(ecl)?.value != null

    private fun validHairColor(hcl: String): Boolean {
        val value = """#([a-f|0-9]+)""".toRegex().find(hcl)?.value
        return value != null && value.length == 7
    }

    private fun validHeight(hgt: String): Boolean {
        val (number, unitType) = """(\d+)(\w+)""".toRegex().find(hgt)?.destructured ?: error("Error hgt")
        val integ = number.toIntOrNull() ?: return false

        return when (unitType) {
            "cm" -> integ in 150..193
            "in" -> integ in 59..76
            else -> false
        }
    }

    fun solvePart2(stream: InputStream): Int {
        val str = stream.bufferedReader().use(BufferedReader::readText)
        val passPortList = extractPassPortListFromText(str)

        val count = passPortList.count { it.isValidPassPortPart2() }
        println("Valid passports, count: $count of a total of: ${passPortList.size}")

        return count
    }

    data class PassPort(
        val byr: String?, // (Birth Year)
        val iyr: String?, //(Issue Year)
        val eyr: String?, //(Expiration Year)
        val hgt: String?, //(Height)
        val hcl: String?, //(Hair Color)
        val ecl: String?, //(Eye Color)
        val pid: String?, //(Passport ID)
        val cid: String? //(Country ID)
    )
}


