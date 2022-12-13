package pairmatching.view

import camp.nextstep.edu.missionutils.Console
import pairmatching.exception.Validator

class InputView {

    private val validator = Validator()

    fun readMenuOption(): String {
        val input = Console.readLine()
        return validator.checkMenuOptionInput(input)
    }

    fun readPairMatching(): List<String> {
        val input = Console.readLine()
        return validator.checkPairMatchingInput(input)
    }

    fun readReMatch(): String {
        val input = Console.readLine()
        return input
    }
}