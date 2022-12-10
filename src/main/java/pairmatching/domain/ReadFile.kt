package pairmatching.domain

import java.io.FileReader

class ReadFile {

    private val path = "C:\\Users\\gju06\\Desktop\\kotlin-pairmatching-precourse\\src\\main\\resources\\"

    fun readFECrew(): List<String> {
        val fePath = "${path}frontend-crew.md"
        return read(fePath)
    }

    fun readBECrew(): List<String> {
        val bePath = "${path}backend-crew.md"
        return read(bePath)
    }

    fun read(path:String): List<String>{
        val read = FileReader(path)
        return read.readLines()
    }
}