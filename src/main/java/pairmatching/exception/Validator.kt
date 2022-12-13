package pairmatching.exception

import pairmatching.constants.ErrorMessage
import pairmatching.constants.MenuOption

class Validator {

    fun checkMenuOptionInput(input: String): String {
        return when (input) {
            MenuOption.MATCHING_PAIR.getOption() -> input
            MenuOption.VIEW_PAIR.getOption() -> input
            MenuOption.RESET_PAIR.getOption() -> input
            MenuOption.QUIT.getOption() -> input
            else -> throw IllegalArgumentException(ErrorMessage.ERRROR_MENU_OPTION.getMessage())
        }
    }

    fun checkPairMatchingInput(input: String): List<String> {
        val inputSplit = input.split(",")
        inputSplit.forEach { it.replace(" ", "") }
        if (inputSplit.size != 3) throw IllegalArgumentException(ErrorMessage.ERROR_PAIR_MATCHING_INPUT.getMessage())
        return inputSplit
    }
}