package pairmatching.domain

import camp.nextstep.edu.missionutils.Randoms
import pairmatching.constants.ErrorMessage

class MatchPair {
    fun match(crews: List<String>, pairs: List<Set<String>>): List<Set<String>> {
        println("이미 만들어진 페어: $pairs")
        if (crews.size % 2 == 0) return matchEven(crews, pairs)
        return matchOdd(crews, pairs)
    }

    private fun matchEven(crews: List<String>, pairs: List<Set<String>>): List<Set<String>> {
        val result = mutableListOf<Set<String>>()
        var count = 1
        while (count < 4) {
            var reMatch = false
            val names = shuffle(crews)
            for (i in names.indices step 2) {
                val tmp = setOf(names[i], names[i + 1])
                println("만들려는 페어: $tmp")
                if (!checkAvailable(pairs, tmp)) {
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

    private fun matchOdd(crews: List<String>, pairs: List<Set<String>>): List<Set<String>> {
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
                if (!checkAvailable(pairs, tmp)) {
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

    private fun checkAvailable(pairs: List<Set<String>>, target: Set<String>): Boolean {
        for (pair in pairs) {
            if (pair.containsAll(target)) return false
        }
        return true
    }
}