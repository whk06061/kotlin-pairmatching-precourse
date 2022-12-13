package pairmatching.view

import pairmatching.constants.MenuMent
import pairmatching.constants.PairMatchingMent

class OutputView {

    fun printMenuMent() {
        println(MenuMent.CHOOSE_MENU.getMessage())
        println(MenuMent.MENU1.getMessage())
        println(MenuMent.MENU2.getMessage())
        println(MenuMent.MENU3.getMessage())
        println(MenuMent.QUIT.getMessage())
    }

    fun printErrorMessage(message: String) {
        println(message)
    }

    fun printPairMatchingMent() {
        println()
        println(PairMatchingMent.DIVISION.getMessage())
        println(PairMatchingMent.COURSE.getMessage())
        println(PairMatchingMent.MISSION.getMessage())
        println(PairMatchingMent.DIVISION.getMessage())
        println(PairMatchingMent.INPUT_MENT.getMessage())
    }

    fun printReMatchMent() {
        println(PairMatchingMent.REMATCH_MENT.getMessage())
    }

    fun printMatchResult(pairs: List<Set<String>>) {
        println()
        println(PairMatchingMent.MATCHING_RESULT_MENT.getMessage())
        for (pair in pairs) {
            for ((index, name) in pair.withIndex()) {
                print(name)
                if (index != pair.size - 1) print(" : ")
            }
            println()
        }
        println()
    }

    fun printResetMent() {
        println()
        println(PairMatchingMent.RESET.getMessage())
        println()
    }
}