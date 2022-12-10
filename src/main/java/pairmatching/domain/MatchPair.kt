package pairmatching.domain

import camp.nextstep.edu.missionutils.Randoms
import pairmatching.constants.ErrorMessage

class MatchPair {
    fun match(crews: List<String>, levelPairs: List<List<Set<String>>>): List<Set<String>> {
        if (crews.size % 2 == 0) return matchEven(crews, levelPairs)
        return matchOdd(crews, levelPairs)
    }

    private fun matchEven(crews: List<String>, levelPairs: List<List<Set<String>>>): List<Set<String>> {
        val result = mutableListOf<Set<String>>()
        var count = 1
        while (count < 4) {
            var reMatch = false
            val names = shuffle(crews)
            for (i in names.indices step 2) {
                val tmp = setOf(names[i], names[i + 1])
                if (!checkAvailable(levelPairs, tmp)) {
                    count += 1
                    result.clear()
                    reMatch = true
                    break
                }
                result.add(tmp)
            }
            if (reMatch == false) return result
        }
        throw IllegalArgumentException(ErrorMessage.ERROR_MATCHING_IMPOSSIBLE.getMessage())
    }

    private fun matchOdd(crews: List<String>, levelPairs: List<List<Set<String>>>): List<Set<String>> {
        val result = mutableListOf<Set<String>>()
        var count = 1
        while (count < 4) {
            var reMatch = false
            val names = shuffle(crews)
            for (i in 0..names.size - 3 step 2) {
                var tmp: Set<String>
                if (i == names.size - 3) {
                    tmp = setOf(names[i], names[i + 1], names[i + 2])
                } else {
                    tmp = setOf(names[i], names[i + 1])
                }
                if (!checkAvailable(levelPairs, tmp)) {
                    count += 1
                    result.clear()
                    reMatch = true
                    break
                }
                result.add(tmp)
            }
            if (reMatch == false) return result
        }
        throw IllegalArgumentException(ErrorMessage.ERROR_MATCHING_IMPOSSIBLE.getMessage())
    }

    private fun shuffle(crews: List<String>): List<String> {
        return Randoms.shuffle(crews)
    }

    private fun checkAvailable(levelPairs: List<List<Set<String>>>, target: Set<String>): Boolean {
        for (pairs in levelPairs) {
            for (pair in pairs) {
                if (pair.containsAll(target)) return false
            }
        }
        return true
    }
}