package pairmatching.view

import camp.nextstep.edu.missionutils.Console
import pairmatching.exception.Validator

class InputView {

    private val validator = Validator()

    fun readMenuOption(): String {
        val input = Console.readLine()
        return validator.checkMenuOption(input)
    }
}