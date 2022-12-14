package pairmatching.domain

import camp.nextstep.edu.missionutils.Randoms
import pairmatching.constants.ErrorMessage

class MatchPairs {
    fun match(crews: List<String>, levelsPairs: List<List<Set<String>>>): List<Set<String>> {
        if (crews.size % 2 == 0) return matchEven(crews, levelsPairs)
        return matchOdd(crews, levelsPairs)
    }

    private fun matchEven(crews: List<String>, levelsPairs: List<List<Set<String>>>): List<Set<String>> {
        val result = mutableListOf<Set<String>>()
        var count = 1
        while (count < 4) {
            var reMatch = false
            val names = Randoms.shuffle(crews)
            for (i in names.indices step 2) {
                val addPair = setOf(names[i], names[i + 1])
                if (!checkCrewAvailable(levelsPairs, addPair)) {
                    count += 1
                    result.clear()
                    reMatch = true
                    break
                }
                result.add(addPair)
            }
            if (!reMatch) return result
        }
        throw IllegalArgumentException(ErrorMessage.ERROR_MATCHING_IMPOSSIBLE.getMessage())
    }

    private fun matchOdd(crews: List<String>, levelsPairs: List<List<Set<String>>>): List<Set<String>> {
        val result = mutableListOf<Set<String>>()
        var count = 1
        while (count < 4) {
            var reMatch = false
            val names = Randoms.shuffle(crews)
            for (i in 0..names.size - 3 step 2) {
                val addPair = if (i == names.size - 3) {
                    setOf(names[i], names[i + 1], names[i + 2])
                } else {
                    setOf(names[i], names[i + 1])
                }
                if (!checkCrewAvailable(levelsPairs, addPair)) {
                    count += 1
                    result.clear()
                    reMatch = true
                    break
                }
                result.add(addPair)
            }
            if (!reMatch) return result
        }
        throw IllegalArgumentException(ErrorMessage.ERROR_MATCHING_IMPOSSIBLE.getMessage())
    }

    private fun checkCrewAvailable(levelPairs: List<List<Set<String>>>, target: Set<String>): Boolean {
        for (pairs in levelPairs) {
            for (pair in pairs) {
                if (pair.containsAll(target)) return false
            }
        }
        return true
    }
}