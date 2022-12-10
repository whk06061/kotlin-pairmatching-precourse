package pairmatching.exception

import pairmatching.constants.ErrorMessage
import pairmatching.constants.MenuOption

class Validator {

    fun checkMenuOption(input: String): String {
        return when (input) {
            MenuOption.MATCHING_PAIR.getOption() -> input
            MenuOption.VIEW_PAIR.getOption() -> input
            MenuOption.RESET_PAIR.getOption() -> input
            MenuOption.QUIT.getOption() -> input
            else -> throw IllegalArgumentException(ErrorMessage.ERRROR_MENU_OPTION.getMessage())
        }
    }
}