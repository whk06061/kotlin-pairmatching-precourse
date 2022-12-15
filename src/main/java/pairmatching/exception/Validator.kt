package pairmatching.exception

import pairmatching.constants.ErrorMessage
import pairmatching.constants.Level
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
        val result = mutableListOf<String>()
        inputSplit.forEach { result.add(it.replace(" ", "")) }
        if (result.size != 3) throw IllegalArgumentException(ErrorMessage.ERROR_PAIR_MATCHING_INPUT.getMessage())
        val level = result[1]
        val mission = result[2]
        Level.values().forEach {
            if (it.getLevelName() == level) {
                if (!it.getMissions()
                        .contains(mission)
                ) throw IllegalArgumentException(ErrorMessage.ERROR_MISSION_NAME.getMessage())
            }
        }
        return result
    }
}