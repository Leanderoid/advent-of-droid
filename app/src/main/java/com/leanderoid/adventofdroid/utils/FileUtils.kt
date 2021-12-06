package com.leanderoid.adventofdroid.utils

import android.content.Context
import java.io.BufferedReader
import java.io.File
import java.io.InputStream

object FileUtils {

    fun getFile(context: Context, fileName: String): InputStream = context.assets.open(fileName)

    fun String.toInputStream() = File(this)
        .readText()
        .byteInputStream()

    fun streamToList(stream: InputStream): List<String> {
        val str = stream.bufferedReader().use(BufferedReader::readText)

        return str.lines()
            .filter { it.isNotEmpty() }
    }
}